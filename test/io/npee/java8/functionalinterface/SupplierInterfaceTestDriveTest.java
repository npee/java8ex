package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import io.npee.java8.streams.domain.User;
import java.util.function.Supplier;
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

}