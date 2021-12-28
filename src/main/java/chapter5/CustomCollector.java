package chapter5;

import chapter3.Artist;
import chapter3.SampleData;

import java.util.List;
import java.util.stream.Collectors;

public class CustomCollector {
    private final static String DELIMITER = ", ";
    private final static String PREFIX = "[";
    private final static String SUFFIX = "]";


    public static void main(String[] args) {
        final List<Artist> threeArtists = SampleData.getThreeArtists();

        CustomCollector customCollector = new CustomCollector();

        customCollector.prettyPrint(threeArtists);
        customCollector.prettyPrintUsingReduce(threeArtists);
        customCollector.prettyPrintUsingStringCombiner(threeArtists);
        customCollector.prettyPrintUsingCollectorsJoining(threeArtists);
    }

    <T extends Nameable> void prettyPrint(List<T> nameables) {
        StringBuilder stringBuilder = new StringBuilder("[");
        nameables.forEach(element -> append(stringBuilder, element.getName()));

        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    <T extends Nameable> void prettyPrintUsingReduce(List<T> nameables) {

        final StringBuilder stringBuilder = nameables.stream().reduce(new StringBuilder("["),
                (acc, element) -> append(acc, element.getName()),
                StringBuilder::append);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    <T extends Nameable> void prettyPrintUsingStringCombiner(List<T> nameables) {
        final StringCombinerImpl combiner = nameables.stream()
                .reduce(
                        new StringCombinerImpl("[", "]", ", "),
                        (acc, element) -> {
                            acc.add(element.getName());
                            return acc;
                        },
                        (a, b) -> {
                            a.merge(b);
                            return a;
                        }
                );
        combiner.print();
    }

    <T extends Nameable> void prettyPrintUsingCollectorsJoining(List<T> nameables) {
        final String prettyNames = nameables.stream()
                .map(Nameable::getName)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
        System.out.println(prettyNames);
    }

    private StringBuilder append(StringBuilder builder, String string) {
        StringBuilder toAppend = new StringBuilder(builder);
        if (toAppend.length() > 1) {
            toAppend.append(", ");
        }
        return toAppend.append(string);
    }

}
