package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

class BestPracticeTestDriveTest {

    /**
     * Prefer Standard Functional Interfaces
     */
    @Test
    void prefer_standard_functional_interfaces() {

        Foo foo = parameter -> parameter + " from lambda";
        String resultV1 = UseFooV1.add("Message", foo);

        System.out.println("result = " + resultV1);

        Function<String, String> fn = parameter -> parameter + " from lambda";
        String resultV2 = UseFooV2.add("Message", fn);

        System.out.println("result = " + resultV2);

        assertEquals(resultV1, resultV2);
    }

    @FunctionalInterface
    public interface Foo {
        String method(String string);
    }

    static class UseFooV1 {
        public static String add(String string, Foo foo) {
            return foo.method(string);
        }
    }

    static class UseFooV2 {
        // Remove interface
        public static String add(String string, Function<String, String> fn) {
            return fn.apply(string);
        }
    }
}