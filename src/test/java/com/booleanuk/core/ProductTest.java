package com.booleanuk.core;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreationWithValidData() {
        Product product = new Bagel("ABC123", 99.99f, "Red", Product.ProductType.BAGEL);

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
            new Bagel("XYZ456", -50f, "Blue", Product.ProductType.BAGEL);
        });
    }

    @Test
    public void testSetPriceThrowsExceptionForZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Bagel("XYZ456", 0f, "Blue", Product.ProductType.BAGEL);
        });
    }
}

