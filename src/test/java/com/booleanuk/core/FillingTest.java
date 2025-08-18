package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    @Test
    public void testFillingConstructor() {
        // Test 1: Ensure constructor initializes correctly
        Filling filling = new Filling(10.0f, "SKU123", "Vanilla");

        Assertions.assertEquals(10.0f, filling.getPrice());
        Assertions.assertEquals("SKU123", filling.getSku());
        Assertions.assertEquals("Vanilla", filling.getVariant());
    }

    @Test
    public void testSettersAndGetters() {
        // Test 2: Test setters and getters after object creation
        Filling filling = new Filling(10.0f, "SKU123", "Vanilla");

        filling.setPrice(12.5f);
        filling.setSku("SKU456");
        filling.setVariant("Chocolate");

        Assertions.assertEquals(12.5f, filling.getPrice());
        Assertions.assertEquals("SKU456", filling.getSku());
        Assertions.assertEquals("Chocolate", filling.getVariant());
    }

    @Test
    public void testNullOrEmptyValues() {
        // Test 3: Test setting null or empty values
        Filling filling = new Filling(0.0f, "", "");

        Assertions.assertEquals(0.0f, filling.getPrice());
        Assertions.assertEquals("", filling.getSku());
        Assertions.assertEquals("", filling.getVariant());
    }
}
