package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {


    @Test
    public void bagelFillingShouldReturnFillingOrErrorMsg() {
        Bagel bagel = new Bagel("test", 10, "nice one");
        Assertions.assertNull(bagel.getFilling());
        Bagel bagel2 = new Bagel("test", 10, "nice one");
        Filling filling = new Filling("SKU", 0.5f, "filling");
        Assertions.assertEquals(0.5f, filling.getPrice());
        filling.setPrice(0.13f);
        bagel2.setFilling(filling);
        Assertions.assertEquals(0.13f, bagel2.getFilling().getPrice());
    }

    @Test
    public void getCorrectFillingCost() {
        Bagel bagel = new Bagel("SKU1", 10f, "nice one");
        Filling filling = new Filling("SKU", 0.5f, "filling");
        Assertions.assertEquals(10f, bagel.getPrice());
        bagel.setFilling(filling);
        Assertions.assertEquals(10.5f, bagel.getPrice());
        filling.setPrice(0.13f);
        Assertions.assertEquals(10.13f, bagel.getPrice());

        Assertions.assertThrows(IllegalArgumentException.class, () -> bagel.setPrice(0));
        Assertions.assertDoesNotThrow(() -> bagel.setPrice(1));
    }

}
