package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {

    @Test
    public void testFillingConstructor() {
        Filling filling = new Filling("sku123", 10.0f, "Vanilla");

        Assertions.assertEquals(10.0f, filling.getPrice());
        Assertions.assertEquals("SKU123", filling.getSku());
        Assertions.assertEquals("Vanilla", filling.getVariant());
    }

    @Test
    public void testSettersAndGetters() {
        Filling filling = new Filling("sku123", 10.0f, "Vanilla");

        filling.setPrice(12.5f);
        filling.setSku("SKU456");
        filling.setVariant("Chocolate");

        Assertions.assertEquals(12.5f, filling.getPrice());
        Assertions.assertEquals("SKU456", filling.getSku());
        Assertions.assertEquals("Chocolate", filling.getVariant());
    }

    @Test
    public void testNullOrEmptyValues() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Filling("", 0.0f, "");
        });
        Filling filling = new Filling("", -1f, "");
        Assertions.assertEquals(1f, filling.getPrice()); //defaults
        Assertions.assertEquals("FIL", filling.getSku()); //defaults
        Assertions.assertEquals("plain", filling.getVariant()); //defaults
    }
}
