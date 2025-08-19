package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.Product;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testBasketConstructor() {
        Basket basket = new Basket("small", 10);
        assertEquals(10, basket.getCapacity());
        assertNotNull(basket.getBasketType());

        Basket basket2 = new Basket("  ", 0);
        assertNotEquals(0, basket2.getCapacity()); // Should default to 5;
        assertEquals(5, basket2.getCapacity());
        assertNotNull(basket2.getBasketType()); // should default to small
    }

    @Test
    public void setBasketTypeNotNull() {
        Basket basket = new Basket("small", 5);

        basket.setBasketType("medium");
        assertNotNull(basket.getBasketType());
        basket.setBasketType("");
        assertNotNull(basket.getBasketType());
        basket.setBasketType("  ab");
        assertNotNull(basket.getBasketType());
        basket.setBasketType(null);
        assertNotNull(basket.getBasketType());
    }

    @Test
    public void getTotalCostOfBasket() {
        Basket basket = new Basket("", 0);
        Bagel bagel = new Bagel("sku", 10, "nice one", Product.ProductType.BAGEL);

        basket.addBagel(bagel);
        assertEquals(10, basket.getTotalCost());
        Bagel bagel2 = new Bagel("sku2", 55, "good one", Product.ProductType.BAGEL);
        basket.addBagel(bagel2);
        assertEquals(65, basket.getTotalCost());
        basket.removeBagel(bagel);
        assertEquals(55, basket.getTotalCost());
    }
}
