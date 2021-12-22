package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class FilterTestDriveMapFlatMapTest {

    @Test
    void filterTest() {
        // filter
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6");
        Stream<String> stream1 = list.stream();
        Stream<String> filteredStream = stream1.filter(s -> !s.equals("1"));
        filteredStream.forEach(System.out::println);

        // map
        Stream<String> stream2 = list.stream();
        Stream<Integer> mappedStream = stream2.map(s -> Integer.valueOf(s)).map(i -> i * i);
        mappedStream.forEach(System.out::println);

        // flatMap
        String[][] _2dArray = {{"1", "a"}, {"2", "b"}, {"3", "c"}, {"4", "d"}, {"5", "e"}, {"6", "f"}};
        Stream<String[]> arrayStream = Arrays.stream(_2dArray);
        Stream<String> stringStream = arrayStream.flatMap(s -> Arrays.stream(s));
        stringStream.forEach(System.out::println);

    }
}