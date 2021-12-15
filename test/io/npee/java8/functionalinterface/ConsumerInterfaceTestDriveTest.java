package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.junit.jupiter.api.Test;

class ConsumerInterfaceTestDriveTest {

    @Test
    void consumerTest() {
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("consumer");
    }

    @Test
    void primitiveConsumerTest() {
        IntConsumer consumer = n -> System.out.println(n + 10000);
        consumer.accept(1000);
        consumer.accept(2000);
    }
}