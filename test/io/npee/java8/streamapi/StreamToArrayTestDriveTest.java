package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class StreamToArrayTestDriveTest {

    @Test
    void stream_to_array() {
        List<String> langs = new ArrayList<>();
        langs.add("java");
        langs.add("kotlin");
        langs.add("haskell");
        langs.add("ruby");
        langs.add("javascript");

        String[] result = langs.toArray(String[]::new);
        Arrays.stream(result).forEach(System.out::println);
    }

}