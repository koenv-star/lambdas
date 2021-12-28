package chapter5;

import chapter3.Artist;
import chapter3.SampleData;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise2 {
    private final static Comparator<Artist> byNameLength = Comparator.comparing((artist) -> artist.getName().length());

    public static void main(String[] args) {
        List<Artist> threeArtists = SampleData.getThreeArtists();
        Exercise2 exercise2 = new Exercise2();

        String nameUsingReduce = exercise2.longestNameUsingReduce(threeArtists).getName();
        System.out.println(nameUsingReduce);

        String nameUsingCollector = exercise2.longestNameUsingCollector(threeArtists).getName();
        System.out.println(nameUsingCollector);

        Map<String, Long> wordOccurence = exercise2.wordOccurence(List.of("John", "Paul", "John"));
        System.out.println(wordOccurence);

        GroupingBy<String, Integer> stringIntegerGroupingBy = new GroupingBy<>(String::length);
        Map<Integer, List<String>> results = Stream.of("a", "b", "cc", "dd")
                .collect(stringIntegerGroupingBy);

        System.out.println(results);
    }

    public Artist longestNameUsingReduce(List<Artist> artists) {
        return artists.stream()
                .reduce((acc, artist) -> byNameLength.compare(artist, acc) >= 0 ? artist : acc)
                .orElseThrow();
    }

    public Artist longestNameUsingCollector(List<Artist> artists) {
        return artists.stream()
                .collect(Collectors.maxBy(byNameLength))
                .orElseThrow();
    }

    public Map<String, Long> wordOccurence(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
