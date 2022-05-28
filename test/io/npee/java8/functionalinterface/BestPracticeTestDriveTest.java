package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;
import java.util.function.Supplier;
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

    /**
     * Use the @FunctionalInterface Annotation
     */
    @Test
    void use_the_functional_interface_annotation() {
    }

    public interface NotAnnotatedFoo {
        String method();
    }

    @FunctionalInterface
    public interface AnnotatedFoo {
        String method();
    }

    /**
     * Don't Overuse Default Methods in Functional Interfaces
     */
    @Test
    void do_not_overuse_default_methods_in_functional_interfaces() {
        ExtendedFoo extendedFoo = string -> "foo " + string;
        String res = extendedFoo.method("string");
        String bar = extendedFoo.defaultBar();
        String baz = extendedFoo.defaultBaz();
        System.out.println("res = " + res);
        System.out.println("bar = " + bar);
        System.out.println("baz = " + baz);
    }

    @FunctionalInterface
    public interface ExtendedFoo extends Bar, Baz {
        @Override
        default String defaultCommon() {
            return Bar.super.defaultCommon(); // Bad Practice
        }
    }

    @FunctionalInterface
    public interface Baz {
        String method(String string);
        default String defaultBaz() {
            return "default baz";
        }
        // Add defaultCommon each interfaces
        default String defaultCommon(){
            return "default common";
        }
    }

    @FunctionalInterface
    public interface Bar {
        String method(String string);
        default String defaultBar() {
            return "default bar";
        }
        // Add defaultCommon each interfaces
        default String defaultCommon(){
            return "default common";
        }
    }

}