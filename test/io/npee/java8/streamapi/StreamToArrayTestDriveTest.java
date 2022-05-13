package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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

    @Test
    void stream_to_powered_integer_array() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        Integer[] result = nums.stream().map(i -> i * i).toArray(Integer[]::new);
        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    void intStream_to_Integer_array() {
        int[] nums = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(nums);

        Integer[] result = intStream
            .map(i -> i * i)
            .boxed()
            .toArray(Integer[]::new);

        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    void intStream_to_primitive_int_array() {
        int[] nums = {1, 2, 3};

        IntStream intStream = Arrays.stream(nums);

        int[] result = intStream
            .map(i -> i * i)
            .toArray();

        Arrays.stream(result).forEach(System.out::println);
        assertInstanceOf(int[].class, result);
    }

}