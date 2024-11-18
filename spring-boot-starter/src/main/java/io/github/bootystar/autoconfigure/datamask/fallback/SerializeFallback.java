package io.github.bootystar.autoconfigure.datamask.fallback;


import java.util.function.Function;

/**
 * @author bootystar
 */
public class SerializeFallback implements Function<Object,String> {

    @Override
    public String apply(Object o) {
        if (o==null) return null;
        String source = String.valueOf(o);
        if (source == null || source.isEmpty()) return source;
        if (source.length() == 1) return "*";
        if (source.length() == 2) return source.charAt(0) + "*";
        int index = source.length() / 3;
        int last = source.length() % 3;
        StringBuilder repeatedPart = new StringBuilder();
        for (int i = 0; i < index + last; i++) {
            repeatedPart.append("*");
        }
        return source.substring(0, index) + repeatedPart + source.substring(source.length() - index);
    }



}
