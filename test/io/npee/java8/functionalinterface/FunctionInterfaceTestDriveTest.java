package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class FunctionInterfaceTestDriveTest {

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

    @Test
    void shortToByteFunctionTest() {
        short[] array = {(short) 1, (short) 2, (short) 3};
        byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));

        assertArrayEquals(new byte[]{(byte)2, (byte)4, (byte)6}, transformedArray);
    }

    public byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }

    @Test
    void biFunctionTest() {
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);

        assertEquals(50000, salaries.get("John"));
        assertEquals(30000, salaries.get("Freddy"));
        assertEquals(60000, salaries.get("Samuel"));
    }

    /**
     * public interface Runnable {
     *      public abstract void run();
     * }
     */
    @Test
    void runnable_test() {
        Runnable runnable = () -> System.out.println("This is runnable interface");
        runnable.run();
    }

    /**
     * public interface Supplier<T> {
     *     T get();
     * }
     */
    @Test
    void supplier_test() {
        Supplier<String> supplier = () -> "This is supplier interface";
        String suppliedString = supplier.get();
        System.out.println("suppliedString = " + suppliedString);
    }
}