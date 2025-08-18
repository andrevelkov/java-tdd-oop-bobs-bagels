package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {


    @Test
    public void bagelFillingShouldReturnFillingOrErrorMsg() {
        Bagel bagel = new Bagel("test", 10, "nice one", "nice");
        Assertions.assertNotNull(bagel.getFilling());
        Bagel bagel2 = new Bagel("test", 10, "nice one", "nice");
        Filling filling = new Filling(0.5f, "SKU", "niceFilling");
        filling.setPrice(0.13f);
        bagel2.setFilling(filling);
        Assertions.assertEquals(0.13f, bagel2.getFilling().getPrice());
    }

    @Test
    public void getCorrectFillingCost() {
        Bagel bagel = new Bagel("test", 10, "nice one", "nice");
        Filling filling = new Filling(0.5f, "SKU", "niceFilling");
        Assertions.assertEquals(10.5, bagel.getPrice());
        filling.setPrice(0.13f);
        Assertions.assertEquals(10.13, bagel.getPrice());
    }
}
