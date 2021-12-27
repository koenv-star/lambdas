package chapter4;

import chapter3.Artist;

import java.util.stream.Stream;

public interface Performance {
    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
        return getMusicians()
                .flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers().stream()));
    }
}
