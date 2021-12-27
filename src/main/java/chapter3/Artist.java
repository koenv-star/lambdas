package chapter3;

import java.util.List;

public class Artist {
    private final String name;
    private final String nationality;
    private final List<Artist> members;

    public Artist(String name, String nationality) {
        this(name, List.of(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        this.name = name;
        this.nationality = nationality;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public List<Artist> getMembers() {
        return members;
    }
}
