package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class MethodReferenceTestDriveTest {

    @Test
    void reference_to_a_static_method() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> powResult = nums.stream().map(n -> Math.pow(n, 2)).collect(Collectors.toList());
        // powResult.forEach(r -> System.out.println(r));
        powResult.forEach(System.out::println); // Static method
    }
}