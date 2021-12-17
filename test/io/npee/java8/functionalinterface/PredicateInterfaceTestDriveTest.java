package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class PredicateInterfaceTestDriveTest {

    @Test
    void predicateTest() {
        Predicate<Integer> predicate = (num) -> num == 0;

        boolean result = predicate.test(100);

        assertFalse(result);
    }

}