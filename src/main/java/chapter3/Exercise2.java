package chapter3;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {
        Exercise2 exercise2 = new Exercise2();

        System.out.println("members : " + exercise2.getTotalMembers(SampleData.threeArtists().collect(Collectors.toList())));
        System.out.println("members : " + exercise2.getTotalMembersAlternative(SampleData.threeArtists().collect(Collectors.toList())));

    }

    public int getTotalMembers(List<Artist> artists) {
        return artists.stream().mapToInt(artist -> artist.getMembers().size()).sum();
    }

    public int getTotalMembersAlternative(List<Artist> artists) {
        return artists.stream().reduce(0, (subtotal, artist) -> subtotal + artist.getMembers().size(), Integer::sum);
    }
}
