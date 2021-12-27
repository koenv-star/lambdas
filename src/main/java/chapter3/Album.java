package chapter3;

import java.util.List;
import java.util.Objects;

public class Album {
    private final String name;
    private final List<Track> tracks;
    private final List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        this.name = Objects.requireNonNull(name);
        this.tracks = Objects.requireNonNull(tracks);
        this.musicians = Objects.requireNonNull(musicians);
    }

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }
}
