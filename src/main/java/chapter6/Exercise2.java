package chapter6;

import java.util.List;

public class Exercise2 {

    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }

/*    BUG!!!
public static int multiplyThroughParallel(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }*/

    public static int multiplyThroughParallel(List<Integer> linkedListOfNumbers) {
        return 5 * linkedListOfNumbers.stream()
                .reduce(1, (acc, x) -> x * acc);
    }
}
