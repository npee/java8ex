package io.npee.java8.optional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class OptionalTestDriveTest {

    @Test
    void ofTest() {
        String string = "optional";
        Optional<String> optionalString = Optional.of(string);
        String s = optionalString.get();
        assertEquals("optional", s);
    }

    @Test
    void ofNullableTest() {
        // NPE 방지
        String string = null;
        assertThrows(NullPointerException.class, () -> Optional.of(string));

        String string2 = null;
        Optional<String> nullString = Optional.ofNullable(string2);
        assertThrows(NoSuchElementException.class, () -> nullString.get());
    }

    @Test
    void emptyTest() {
        Optional<String> empty = Optional.empty();
        assertThrows(NoSuchElementException.class, () -> empty.get());
    }

    @Test
    void isPresentTest() {
        Optional<String> optionalString1 = Optional.of("optional");
        Optional<String> optionalString2 = Optional.ofNullable("optional");
        Optional<String> optionalString3 = Optional.ofNullable(null);

        System.out.println("-- isPresent() --");
        if (optionalString1.isPresent()) {
            System.out.println(optionalString1.get());
        }

        if (optionalString2.isPresent()) {
            System.out.println(optionalString2.get());
        }

        if (optionalString3.isPresent()) {
            System.out.println(optionalString3.get());
        }

        System.out.println("-- ifPresent() --");

        optionalString1.ifPresent(System.out::println);

        optionalString2.ifPresent(System.out::println);

        optionalString3.ifPresent(System.out::println);

    }

    @Test
    void orElseTest() {
        String nullString = null;
        Optional<String> optionalString1 = Optional.of("optional");
        Optional<String> optionalString2 = Optional.ofNullable(nullString);

        String str1 = optionalString1.orElse("orElse");
        assertEquals("optional", str1);

        String str2 = optionalString2.orElse("orElse");
        assertEquals("orElse", str2);
    }

    @Test
    void orElseGetTest() {
        String nullString = null;
        Optional<String> optionalString1 = Optional.of("optional");
        Optional<String> optionalString2 = Optional.ofNullable(nullString);

        String str1 = optionalString1.orElseGet(() -> "orElseGet");
        assertEquals("optional", str1);

        String str2 = optionalString2.orElseGet(() -> "orElseGet");
        assertEquals("orElseGet", str2);
    }

    @Test
    void orElseThrowTest() {
        String nullString = null;
        Optional<String> optionalString1 = Optional.of("optional");
        Optional<String> optionalString2 = Optional.ofNullable(nullString);

        String str1 = optionalString1.orElseThrow(NullPointerException::new);
        assertEquals("optional", str1);

        assertThrows(NullPointerException.class, () -> optionalString2.orElseThrow(NullPointerException::new));

    }
}