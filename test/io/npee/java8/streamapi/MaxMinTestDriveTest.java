package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class MaxMinTestDriveTest {

    @Test
    void maxTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        final Comparator<String> comparator = (s1, s2) -> s1.compareToIgnoreCase(s2);
        Optional<String> optionalMaxString = langs.stream().max(comparator);
        optionalMaxString.ifPresent(System.out::println);
        assertEquals("ruby", optionalMaxString.get());
    }

}