package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FillingTest {

    @Test
    public void testFillingConstructor() {
        Filling filling = new Filling("sku123", 10.0f, "Vanilla");

        assertEquals(10.0f, filling.getPrice());
        assertEquals("SKU123", filling.getSku());
        assertEquals("Vanilla", filling.getVariant());
    }

    @Test
    public void testSettersAndGetters() {
        Filling filling = new Filling("sku123", 10.0f, "Vanilla");

        filling.setPrice(12.5f);
        filling.setSku("SKU456");
        filling.setVariant("Chocolate");

        assertEquals(12.5f, filling.getPrice());
        assertEquals("SKU456", filling.getSku());
        assertEquals("Chocolate", filling.getVariant());
    }

    @Test
    public void testNullOrEmptyValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Filling("", 0.0f, "");
        });
        Filling filling = new Filling("", -1f, "");
        assertEquals(1f, filling.getPrice()); //defaults
        assertEquals("FIL", filling.getSku()); //defaults
        assertEquals("plain", filling.getVariant()); //defaults
    }
}
