package chapter5;

public interface StringCombiner {

    void add(String element);

    void merge(StringCombiner combiner);

    StringBuilder getBuilder();
}
