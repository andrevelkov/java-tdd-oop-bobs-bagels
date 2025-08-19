package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.sql.Time;

public class CustomerTest {

    @Test
    public void verifyBasketAfterAddAndRemove() {
        Basket basket = new Basket("", 5);
        Customer customer = new Customer(basket);

        Bagel bagel = new Bagel("new", 5, "test");

        customer.addBagelToBasket(new Bagel("test1", 10, "test1"));
        customer.addBagelToBasket(new Bagel("2", 4, "test1"));
        assertEquals(2, customer.getAmountOfBagelsInBasket());
        customer.addBagelToBasket(bagel);
        assertEquals(3, customer.getAmountOfBagelsInBasket());
        customer.removeBagelFromBasket(new Bagel("4", 11, "test1"));
        assertEquals(3, customer.getAmountOfBagelsInBasket());
        customer.removeBagelFromBasket(bagel);
        assertEquals(2, customer.getAmountOfBagelsInBasket());
    }

    @Test
    public void orderBagelAtSpecificTimeShouldReturnTimeAndBagels() {
        Basket basket = new Basket("", 5);
        Customer customer = new Customer(basket);
        Bagel bagel = new Bagel("SKU123", 10f, "NICEUU");
        customer.addBagelToBasket(bagel);
        Time time = Time.valueOf("10:00:00");
        assertEquals("Order: 10:00:00, Bagel: NICEUU", customer.orderBagelAtSpecificTime(time, bagel));
    }

    @Test
    public void getCorrectTotalCostOfCustomerBasket() {
        Customer customer = new Customer(new Basket("", 5));
        customer.addBagelToBasket(new Bagel("test1", 10, "test1"));
        customer.addBagelToBasket(new Bagel("2", 4, "test1"));

        Bagel bagel = new Bagel("SKU123", 14f, "NIce one");
        Filling filling = new Filling("SKU123", 0.8f, "Chocolate");
        bagel.setFilling(filling);
        customer.addBagelToBasket(bagel);

        assertEquals(28.8f, customer.getTotalCost());
        customer.removeBagelFromBasket(bagel);
        assertEquals(14, customer.getTotalCost());
    }

    @Test
    public void getSingleBagelPriceFromBasket() {
        Customer customer = new Customer(new Basket("", 5));
        customer.addBagelToBasket(new Bagel("test1", 10, "test1"));
        customer.addBagelToBasket(new Bagel("2", 4, "test1"));

        Bagel bagel = new Bagel("SKU123", 14f, "NIce one");
        Filling filling = new Filling("SKU123", 0.8f, "Chocolate");
        bagel.setFilling(filling);
        customer.addBagelToBasket(bagel);

        assertEquals(14.8f, customer.getBagelPrice(bagel));
        customer.removeBagelFromBasket(bagel);
        assertNotEquals(14.8f, customer.getBagelPrice(bagel));
        assertEquals(-1, customer.getBagelPrice(bagel));

    }
}
