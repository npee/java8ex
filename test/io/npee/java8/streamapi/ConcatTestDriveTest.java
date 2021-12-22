package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class ConcatTestDriveTest {

    @Test
    void concatTest() {
        // 스트림 다음에 다른 스트림을 이어붙일 때 사용
        List<String> numberList = Arrays.asList("1", "2", "3", "4", "5");
        List<String> charList = Arrays.asList("a", "b", "c", "d", "e");
        Stream<String> stream1 = numberList.stream();
        Stream<String> stream2 = charList.stream();
        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(System.out::println);
    }

}