package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testBasketConstructor() {
        Basket basket = new Basket("small", 10);
        Assertions.assertEquals(10, basket.getCapacity());
        Assertions.assertNotNull(basket.getBasketType());

        Basket basket2 = new Basket("  ", 0);
        Assertions.assertNotEquals(0, basket2.getCapacity()); // Should default to 5;
        Assertions.assertEquals(5, basket2.getCapacity());
        Assertions.assertNotNull(basket2.getBasketType()); // should default to small
    }

    @Test
    public void setBasketTypeNotNull() {
        Basket basket = new Basket("small", 5);

        basket.setBasketType("medium");
        Assertions.assertNotNull(basket.getBasketType());
        basket.setBasketType("");
        Assertions.assertNotNull(basket.getBasketType());
        basket.setBasketType("  ab");
        Assertions.assertNotNull(basket.getBasketType());
        basket.setBasketType(null);
        Assertions.assertNotNull(basket.getBasketType());
    }

    @Test
    public void getTotalCostOfBasket() {
        Basket basket = new Basket("", 0);
        Bagel bagel = new Bagel("sku", 10, "nice one");

        basket.addBagel(bagel);
        Assertions.assertEquals(10, basket.getTotalCost());
        Bagel bagel2 = new Bagel("sku2", 55, "good one");
        basket.addBagel(bagel2);
        Assertions.assertEquals(65, basket.getTotalCost());
        basket.removeBagel(bagel);
        Assertions.assertEquals(55, basket.getTotalCost());
    }
}
