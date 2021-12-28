package chapter5;

import java.util.Objects;

public class StringCombinerImpl implements StringCombiner {
    private final String prefix;
    private final String suffix;
    private final String delimiter;
    private final StringBuilder builder = new StringBuilder();

    public StringCombinerImpl(String prefix, String suffix, String delimiter) {
        this.prefix = Objects.requireNonNull(prefix);
        this.suffix = Objects.requireNonNull(suffix);
        this.delimiter = Objects.requireNonNull(delimiter);
    }

    @Override
    public void add(String element) {
        if (atStart()) {
            builder.append(prefix);
        } else {
            builder.append(delimiter);
        }
        builder.append(element);
    }

    @Override
    public void merge(StringCombiner combiner) {
        builder.append(combiner.getBuilder());
    }

    @Override
    public StringBuilder getBuilder() {
        return builder;
    }

    public void print() {
        final StringBuilder toPrint = new StringBuilder(builder);
        System.out.println(toPrint.append(suffix));
    }

    private boolean atStart() {
        return builder.length() == 0;
    }


}
