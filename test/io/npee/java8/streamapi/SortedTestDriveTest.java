package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class SortedTestDriveTest {

    @Test
    void sortedTest() {
        // 커스텀 객체의 경우 Comparator를 구현해야 함
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "smalltalk");
        System.out.println("sorted:");
        langs.stream().sorted().forEach(System.out::println);

        System.out.println("reversed:");
        langs.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    @Test
    void sortedByLengthTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "smalltalk");
        System.out.println("sorted by length:");
        Comparator<String> comparator = (p1, p2) -> Integer.compare(p1.length(), p2.length());
        langs.stream().sorted(comparator).forEach(System.out::println);

        System.out.println("sorted by length desc:");
        langs.stream().sorted(comparator.reversed()).forEach(System.out::println);
    }

}