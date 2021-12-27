package chapter3;

import java.util.List;
import java.util.stream.Stream;

public class Exercise1 {
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();

        System.out.println("addUp: " + exercise1.addUp(Stream.of(1, 4, 5)));
        final String namesAndOrigins = String.join(", ", exercise1.getNamesAndOrigins(SampleData.membersOfTheBeatles));
        System.out.println("names and origins: " + namesAndOrigins);

        final List<Album> albumsWithAtMostThreeTracks = exercise1.getAlbumsWithAtMostThreeTracks(SampleData.albums.toList());
        albumsWithAtMostThreeTracks.forEach((album -> System.out.println(album.getName())));
    }

    public int addUp(Stream<Integer> numbers) {
        return numbers.mapToInt(Integer::intValue).sum();
    }

    public List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getNationality())).toList();
    }

    public List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
        return albums.stream().filter(album -> album.getTracks().size() <= 3).toList();
    }

}
