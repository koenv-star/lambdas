package chapter6;

import java.util.stream.IntStream;

public class Exercise1 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        final int sumOfSquares = sequentialSumOfSquares(IntStream.of(2));
        long endTime = System.currentTimeMillis();
        System.out.println("result: " + sumOfSquares + ". Sequential took " + (endTime - startTime) + " milliseconds");

        long startTimeParallel = System.currentTimeMillis();
        final int sumOfSquaresParallel = sequentialSumOfSquaresParallel(IntStream.of(2));
        long endTimeParallel = System.currentTimeMillis();
        System.out.println("result: " + sumOfSquaresParallel + ". Parallel took " + (endTimeParallel - startTimeParallel) + " milliseconds");
    }

    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                .sum();
    }

    public static int sequentialSumOfSquaresParallel(IntStream range) {
        return range.parallel()
                .map(x -> x * x)
                .sum();
    }
}
