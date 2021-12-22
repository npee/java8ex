package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LimitSkipTestDriveTest {

    @Test
    void limitTest() {
        // 무한대 또는 그에 가까운 스트림의 개수를 제어
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.limit(5);
        stream2.forEach(System.out::println);
    }

    @Test
    void skipTest() {
        // 앞에서부터 n 개의 요소를 제외
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.skip(5);
        stream2.forEach(System.out::println);
    }

}