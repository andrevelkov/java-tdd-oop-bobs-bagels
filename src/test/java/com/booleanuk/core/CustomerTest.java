package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Time;

public class CustomerTest {

    @Test
    public void verifyBasketAfterAddAndRemove() {
        Basket basket = new Basket("", 5);
        Customer customer = new Customer(basket);

        customer.addBagelToBasket(new Bagel("test1", 10, "test1", "test1"));
        customer.addBagelToBasket(new Bagel("2", 4, "test1", "test1"));
        Assertions.assertEquals(2, customer.returnBasketCapacity());
        customer.addBagelToBasket(new Bagel("3", 34, "test1", "test1"));
        Assertions.assertEquals(3, customer.returnBasketCapacity());
        customer.removeBagelFromBasket(new Bagel("4", 11, "test1", "test1"));
        Assertions.assertEquals(2, customer.returnBasketCapacity());
    }

    @Test
    public void orderBagelAtSpecificTimeShouldReturnTimeAndBagels() {
        Basket basket = new Basket("", 5);
        Customer customer = new Customer(basket);
        Time time = Time.valueOf("10:00");

        Assertions.assertEquals("Order: 10:00 , Bagel: ", customer.orderBagelAtSpecificTime(time));
    }
}
