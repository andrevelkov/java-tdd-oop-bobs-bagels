package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreationWithValidData() {
        Product product = new Product("ABC123", 99.99f, "Red");

        // Check if the product's SKU, price, and variant are set correctly
        assertEquals("ABC123", product.getSku());
        assertEquals(99.99f, product.getPrice());
        assertEquals("Red", product.getVariant());

        product.setSku("ABC");
        assertEquals("ABC", product.getSku());
    }

    @Test
    public void testSetPriceThrowsExceptionForNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("XYZ456", -50f, "Blue");
        });
    }

    @Test
    public void testSetPriceThrowsExceptionForZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("XYZ456", 0f, "Blue");
        });
    }
}

