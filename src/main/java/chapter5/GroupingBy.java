package chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {
    private final Function<T, K> classifier;

    public GroupingBy(Function<T, K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, element) -> {
            K key = classifier.apply(element);
            List<T> elements = map.computeIfAbsent(key, (k -> new ArrayList<>()));
            elements.add(element);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (map1, map2) -> {
            map2.forEach(((key, values) -> map1.merge(key, values, (a, b) -> {
                a.addAll(b);
                return a;
            })));
            return map2;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
