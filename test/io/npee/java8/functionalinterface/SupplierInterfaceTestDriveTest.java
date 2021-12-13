package io.npee.java8.functionalinterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class SupplierInterfaceTestDriveTest {

    @Test
    void supplierTest() {
        // 파라미터가 없음
        Supplier<String> supplier = () -> "supplier";
        assertEquals("supplier", supplier.get());
    }

}