package chapter6;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.stream.IntStream;

public class Exercise3 {

    //   private List<Integer> arrayListOfNumbers;
    //   private List<Integer> linkedListOfNumbers;

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(Exercise3.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void init() {
        System.out.println("benchmark");
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                .forEach(container::add);
    }

    //  public int slowSumOfSquares() {
    //      return linkedListOfNumbers.parallelStream()
    //              .map(x -> x * x)
    //              .reduce(0, (acc, x) -> acc + x);
    //  }

    //  public int SumOfSquares() {
    //      return linkedListOfNumbers.parallelStream()
    //              .mapToInt(x -> x * x)
    //              .sum();
    //  }
}
