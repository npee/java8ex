package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class FunctionalInterfaceTest {

    @Test
    void functionTest() {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        for (Entry<String, Integer> stringIntegerEntry : nameMap.entrySet()) {
            // nameMap 에 {John: 4} 가 추가됨
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }
        assertEquals(4, value);
    }

    @Test
    void functionComposeTest() {
        Function<Integer, String> intToString = i -> i.toString();
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> intToQuoteString = quote.compose(intToString);
        assertEquals("'5'", intToQuoteString.apply(5));
    }
}