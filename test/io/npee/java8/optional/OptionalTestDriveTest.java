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


}