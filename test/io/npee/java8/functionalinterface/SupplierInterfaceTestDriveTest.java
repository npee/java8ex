package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.java8.data.domain.User;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class SupplierInterfaceTestDriveTest {

    @Test
    void supplierTest() {
        // 파라미터가 없음
        Supplier<String> supplier = () -> "supplier";
        assertEquals("supplier", supplier.get());
    }

    @Test
    void supplierObjectTest() {
        Supplier<User> userSupplier = () -> new User(1L, "user", "user@email.com", "010-xxxx-xxxx");
        System.out.println(userSupplier.get());
        assertEquals("user", userSupplier.get().getName());
    }

    @Test
    void supplierPrimitiveTest() {
        String s = "supplier";

        BooleanSupplier booleanSupplier = () -> s.equals("function");
        IntSupplier intSupplier = () -> s.length();
        LongSupplier longSupplier = () -> s.length();
        DoubleSupplier doubleSupplier = () -> 0.0 + s.length();

        assertFalse(booleanSupplier.getAsBoolean());
        assertEquals(8, intSupplier.getAsInt());
        assertEquals(8L, longSupplier.getAsLong());
        assertEquals(8.0d, doubleSupplier.getAsDouble());
    }

    @Test
    void supplierStreamTest() {
        Supplier<Integer> randomNumbersSupplier = () -> new Random().nextInt(100);

        Stream.generate(randomNumbersSupplier).limit(5).forEach(System.out::println);
    }

}