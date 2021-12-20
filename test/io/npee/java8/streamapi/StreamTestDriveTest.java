package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StreamTestDriveTest {

    @Test
    void streamTest() {
        // Stream 기본
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(System.out::println);

        // 빈 스트림 생성
        Stream<Object> emptyStream = Stream.empty();

        // 랜덤 숫자 스트림 생성
        Stream<Double> randomStream = Stream.generate(Math::random).limit(6);
        randomStream.forEach(System.out::println);

        // 반복자 스트림 생성
        Stream<Integer> iterateStream = Stream.iterate(1, n -> n * 2).limit(6);
        iterateStream.forEach(System.out::println);

        // 리스트 기반 스트림 생성
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6");
        Stream<String> listStream = list.stream();
        listStream.forEach(System.out::println);

        // 배열 기반 스트림 생성
        int[] intArray = {1, 2, 3, 4, 5, 6};
        Stream<Integer> intStream = Arrays.stream(intArray).boxed();
        intStream.forEach(System.out::println);
    }
}