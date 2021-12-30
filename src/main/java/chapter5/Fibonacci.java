package chapter5;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private Map<Integer, Long> fibonacci = new HashMap<>();

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.calculate(8);
        System.out.println(result);
        System.out.println(fibonacci.fibonacci);
    }

    public Fibonacci() {
        fibonacci.put(0, 0L);
        fibonacci.put(1, 1L);
    }

    public long calculate(int x) {
        Map<Integer, Long> fib = new HashMap<>(fibonacci);
        final Long result = fib.computeIfAbsent(x, n -> calculate(n - 1) + calculate(n - 2));
        fibonacci.put(x, result);
        return result;
    }
}
