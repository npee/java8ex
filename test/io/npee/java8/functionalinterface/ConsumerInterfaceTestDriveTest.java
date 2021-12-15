package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

class ConsumerInterfaceTestDriveTest {

    @Test
    void consumerTest() {
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("consumer");
    }
}