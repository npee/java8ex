package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class ParallelTestDriveTest {

    @Test
    void parallelTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");

        Stream<String> stream = langs.stream();
        stream.forEach(System.out::println);

        Stream<String> stream2 = langs.stream();
        stream2.parallel().forEach(System.out::println);

        Stream<String> stream3 = langs.parallelStream(); // == stream().parallel()
        stream3.forEach(System.out::println);
    }

}