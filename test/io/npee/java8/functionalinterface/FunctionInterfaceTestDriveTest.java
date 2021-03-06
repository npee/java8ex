package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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

    /**
     * public interface Consumer<T> {
     *     void accept(T t);
     *
     *     default Consumer<T> andThen(Consumer<? super T> after) {
     *         Objects.requireNonNull(after);
     *         return (T t) -> { accept(t); after.accept(t); };
     *     }
     * }
     */
    @Test
    void consumer_test() {
        Consumer<String> print = text -> System.out.println("This is " + text + " interface");
        print.accept("consumer");
    }

    @Test
    void consumer_and_then_test() {
        Consumer<String> print = text -> System.out.print("This is " + text + " ");
        Consumer<String> printNext = System.out::println;
        print.andThen(printNext).accept("consumer");
    }

    /**
     * public interface Function<T, R> {
     *     R apply(T t);
     *
     *     default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
     *         Objects.requireNonNull(before);
     *         return (V v) -> apply(before.apply(v));
     *     }
     *
     *     default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
     *         Objects.requireNonNull(after);
     *         return (T t) -> after.apply(apply(t));
     *     }
     *
     *     static <T> Function<T, T> identity() {
     *         return t -> t;
     *     }
     * }
     */
    @Test
    void function_test() {
        Function<Integer, Double> squareRoot = Math::sqrt;
        Double result = squareRoot.apply(10);
        System.out.println(result);
    }

    @Test
    void function_and_then_test() {
        Function<Integer, Double> squareRoot = Math::sqrt;
        Function<Double, String> stringToPrint = value -> "Result is " + value + ".";
        String result = squareRoot.andThen(stringToPrint).apply(10);
        System.out.println(result);
    }

    @Test
    void function_compose_test() {
        // get sum of 1 to n
        Function<Integer, Integer> divideByTwo = value -> value / 2;
        Function<Integer, Integer> multiplyWithPlus1FromItself = value -> value * (value + 1);

        Function<Integer, String> stringToPrint = value -> "Result is " + value + ".";
        String result = divideByTwo.compose(multiplyWithPlus1FromItself).andThen(stringToPrint).apply(100);
        System.out.println(result);
    }

    /**
     * public interface Predicate<T> {
     *     boolean test(T t);
     *
     *     default Predicate<T> and(Predicate<? super T> other) {
     *         Objects.requireNonNull(other);
     *         return (t) -> test(t) && other.test(t);
     *     }
     *
     *     default Predicate<T> negate() {
     *         return (t) -> !test(t);
     *     }
     *
     *     default Predicate<T> or(Predicate<? super T> other) {
     *         Objects.requireNonNull(other);
     *         return (t) -> test(t) || other.test(t);
     *     }
     *
     *     static <T> Predicate<T> isEqual(Object targetRef) {
     *         return (null == targetRef)
     *                 ? Objects::isNull
     *                 : object -> targetRef.equals(object);
     *     }
     * }
     */
    @Test
    void predicate_test() {
        Predicate<Integer> lt500 = num -> num < 500;
        boolean test = lt500.test(499);
        System.out.println("Is this less then 500? -> " + test);
        assertTrue(lt500.test(499));
    }

    @Test
    void predicate_and_or_test() {
        Predicate<Integer> lt500 = num -> num < 500;
        Predicate<Integer> gt300 = num -> num > 300;
        Predicate<Integer> isNegative = num -> num < 0;
        boolean test = lt500.and(gt300).or(isNegative).test(499);
        System.out.println("Is this less than 500 and greater than 300 or negative? -> " + test);
        assertTrue(lt500.and(gt300).or(isNegative).test(499));
    }

    @Test
    void predicate_is_equal_test() {
        Predicate<Integer> isEquals = Predicate.isEqual(499);
        boolean test = isEquals.test(499);
        System.out.println("Is this 499? -> " + test);
        assertTrue(isEquals.test(499));
    }
}