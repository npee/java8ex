package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class DistinctTestDriveTest {

    @Test
    void distinctTest() {
        // 커스텀 객체인 경우 Object.equals()가 구현되어 있어야 제대로 동작
        List<String> list = Arrays.asList("a", "f", "b", "c", "a", "d", "e", "f");

        Stream<String> stream = list.stream();
        Stream<String> distinctStream = stream.distinct();
        distinctStream.forEach(System.out::println);
    }
}