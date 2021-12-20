package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.java8.data.domain.Item;
import java.util.function.BinaryOperator;
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

    @Test
    void binaryOperatorTest() {
        BinaryOperator<Item> maxPrice = BinaryOperator.maxBy((Item i1, Item i2) -> i1.getPrice() - i2.getPrice());
        Item item1 = new Item(1L, "item1", 20000, "아이템1");
        Item item2 = new Item(2L, "item2", 15000, "아이템2");
        Item maxPriceItem = maxPrice.apply(item1, item2);
        assertEquals(1L, maxPriceItem.getId());

        BinaryOperator<Item> minPrice = BinaryOperator.minBy((Item i1, Item i2) -> i1.getPrice() - i2.getPrice());
        Item minPriceItem = minPrice.apply(item2, item1);
        assertEquals(2L, minPriceItem.getId());
    }

}