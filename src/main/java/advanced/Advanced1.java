package advanced;

import chapter3.Artist;
import chapter3.SampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Advanced1 {

    public static void main(String[] args) {

        Advanced1 advanced1 = new Advanced1();

        final List<String> nationalities = advanced1.map(SampleData.threeArtists(), Artist::getNationality);
        System.out.println(String.join(", ", nationalities));

        final List<Artist> artistsFromUK = advanced1.filter(SampleData.threeArtists(), artist -> artist.getNationality().contains("UK"));
        System.out.println(String.join(", ", artistsFromUK.stream().map(Artist::getName).toList()));

    }

    public <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, element) -> {
                    ArrayList<R> result = new ArrayList<>(acc);
                    result.add(mapper.apply(element));
                    return result;
                },
                (a, b) -> {
                    final ArrayList<R> r = new ArrayList<>(a);
                    r.addAll(b);
                    return r;
                });
    }

    public <T> List<T> filter(Stream<T> stream, Predicate<T> filter) {
        return stream.reduce(new ArrayList<>(), (acc, element) -> {
                    ArrayList<T> filtered = new ArrayList<>(acc);
                    if (filter.test(element)) {
                        filtered.add(element);
                    }
                    return filtered;
                },
                (a, b) -> {
                    final ArrayList<T> list = new ArrayList<>(a);
                    list.addAll(b);
                    return list;
                });
    }
}
