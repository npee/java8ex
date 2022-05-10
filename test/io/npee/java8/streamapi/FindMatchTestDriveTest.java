package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindMatchTestDriveTest {

    @Test
    void findTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        Optional<String> firstElement = langs.stream().filter(s -> s.startsWith("j")).findFirst();
        Optional<String> anyElement = langs.stream().filter(s -> s.startsWith("j")).findAny();
        firstElement.ifPresent(System.out::println);
        anyElement.ifPresent(System.out::println);
    }

    @Test
    void findParallelTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        Optional<String> firstElement = langs.stream().parallel().filter(s -> s.startsWith("j")).findFirst();
        Optional<String> anyElement = langs.stream().parallel().filter(s -> s.startsWith("j")).findAny();
        firstElement.ifPresent(System.out::println);
        anyElement.ifPresent(System.out::println);
        assertTrue(anyElement.get().equals("java") || anyElement.get().equals("javascript"));
    }


}