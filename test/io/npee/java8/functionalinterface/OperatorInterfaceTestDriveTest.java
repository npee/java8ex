package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Test;

class OperatorInterfaceTestDriveTest {

    @Test
    void operatorTest() {
        UnaryOperator<Integer> unaryOperator1 = n -> n * n;
        Integer result = unaryOperator1.apply(10);
        assertEquals(100, result);

        UnaryOperator<Boolean> unaryOperator2 = b -> !b;
        Boolean result2 = unaryOperator2.apply(true);
        assertFalse(result2);
    }

    @Test
    void andThenTest() {
        UnaryOperator<Integer> unaryOperator1 = n -> n * n;
        UnaryOperator<Integer> unaryOperator2 = n -> n * 1000;
        Integer result = unaryOperator1.andThen(unaryOperator2).apply(5);
        assertEquals(25000, result);
    }

}