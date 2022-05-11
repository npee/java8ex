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

    @Test
    void matchTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");

        boolean anyMatchExpertsFalse = langs.stream().anyMatch(s -> s.startsWith("a"));
        assertFalse(anyMatchExpertsFalse);

        boolean anyMatchExpertsTrue = langs.stream().anyMatch(s -> s.startsWith("j"));
        assertTrue(anyMatchExpertsTrue);


        boolean allMatchFalse = langs.stream().allMatch(s -> s.startsWith("r"));
        assertFalse(allMatchFalse);

        boolean noneMatchTrue = langs.stream().noneMatch(s -> s.startsWith("x"));
        assertTrue(noneMatchTrue);
    }

    @Test
    void differenceFindAndMatch() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");

        Optional<String> findAny = langs.stream().filter(s -> s.startsWith("k")).findAny();
        boolean anyMatch = langs.stream().anyMatch(s -> s.startsWith("k"));

        assertEquals(findAny.get(), "kotlin");
        assertEquals(anyMatch, true);
    }


}