package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class PredicateInterfaceTestDriveTest {

    @Test
    void predicateTest() {
        Predicate<Integer> predicate = (num) -> num == 0;

        boolean result = predicate.test(100);

        assertFalse(result);
    }

    @Test
    void andTest() {
        Predicate<Integer> testEven = (num) -> num % 2 == 0;
        Predicate<Integer> testLessThan100 = (num) -> num < 100;
        Predicate<Integer> testPositive = (num) -> num > 0;

        int target = 10;
        boolean result = testEven.and(testLessThan100).and(testPositive).test(target);
        assertTrue(result);
    }

    @Test
    void orTest() {
        Predicate<Integer> testEven = (num) -> num % 2 == 0;
        Predicate<Integer> testLessThan100 = (num) -> num < 100;
        Predicate<Integer> testPositive = (num) -> num > 0;

        int target = -20;
        boolean result = testEven.or(testLessThan100).or(testPositive).test(target);
        assertTrue(result);
    }

    @Test
    void isEqualTest() {
        String target = "Predicate";
        boolean result = Predicate.isEqual("predicate").test(target);
        assertFalse(result);
    }

    @Test
    void isEqualInStreamTest() {
        Stream<Integer> intStream = IntStream.range(1, 10).boxed();
        intStream.filter(Predicate.isEqual(5)).forEach(i -> System.out.println(i));
    }

}