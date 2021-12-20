package chapter2;

import static java.time.temporal.ChronoUnit.DAYS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.stream.IntStream;

public class excercice2 {

    public static void main(String[] args) {
        //https://stackoverflow.com/questions/6840803/why-is-javas-simpledateformat-not-thread-safe
        final ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMMM-yyyy"));

        IntStream.range(1, 10).forEach(i -> System.out.println(dateFormatThreadLocal.get().format(Date.from(Instant.now().minus(i, DAYS)))));
    }
}
