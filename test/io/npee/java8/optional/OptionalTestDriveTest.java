package io.npee.java8.optional;

import static org.junit.jupiter.api.Assertions.*;

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



}