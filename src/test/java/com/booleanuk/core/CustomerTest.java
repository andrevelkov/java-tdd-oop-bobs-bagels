package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

public class CustomerTest {
    TestHelper test = new TestHelper();
    List<Product> inventory = test.loadInventoryOnStart();

    @Test
    public void verifyBasketAfterAddAndRemove() {
        Basket basket = new Basket("", 5);
        Customer customer = new Customer(basket, inventory);

        Bagel bagel = new Bagel("new", 5, "test", Product.ProductType.BAGEL);

        customer.addBagelToBasket(new Bagel("test1", 10, "test1", Product.ProductType.BAGEL));
        customer.addBagelToBasket(new Bagel("2", 4, "test1", Product.ProductType.BAGEL));
        assertEquals(2, customer.getAmountOfBagelsInBasket());
        customer.addBagelToBasket(bagel);
        assertEquals(3, customer.getAmountOfBagelsInBasket());
        customer.removeBagelFromBasket(new Bagel("4", 11, "test1", Product.ProductType.BAGEL));
        assertEquals(3, customer.getAmountOfBagelsInBasket());
        customer.removeBagelFromBasket(bagel);
        assertEquals(2, customer.getAmountOfBagelsInBasket());
    }

    @Test
    public void orderBagelAtSpecificTimeShouldReturnTimeAndBagels() {
        Basket basket = new Basket("", 5);
        Customer customer = new Customer(basket, inventory);
        Bagel bagel = new Bagel("SKU123", 10f, "NICEUU", Product.ProductType.BAGEL);
        customer.addBagelToBasket(bagel);
        Time time = Time.valueOf("10:00:00");
        assertEquals("Order: 10:00:00, Bagel: NICEUU", customer.orderBagelAtSpecificTime(time, "plain"));
    }

    @Test
    public void getCorrectTotalCostOfCustomerBasket() {
        Customer customer = new Customer(new Basket("", 5), inventory);
        customer.addBagelToBasket(new Bagel("test1", 10, "test1", Product.ProductType.BAGEL));
        customer.addBagelToBasket(new Bagel("2", 4, "test1", Product.ProductType.BAGEL));

        Bagel bagel = new Bagel("SKU123", 14f, "NIce one", Product.ProductType.BAGEL);
        Filling filling = new Filling("SKU123", 0.8f, "Chocolate", Product.ProductType.FILLING);
        bagel.setFilling(filling);
        customer.addBagelToBasket(bagel);

        assertEquals(28.8f, customer.getTotalCost());
        customer.removeBagelFromBasket(bagel);
        assertEquals(14, customer.getTotalCost());
    }

    @Test
    public void getSingleBagelPriceFromBasket() {
        Customer customer = new Customer(new Basket("", 5), inventory);
        customer.addBagelToBasket(new Bagel("test1", 10, "test1", Product.ProductType.BAGEL));
        customer.addBagelToBasket(new Bagel("2", 4, "test1", Product.ProductType.BAGEL));

        Bagel bagel = new Bagel("SKU123", 14f, "NIce one", Product.ProductType.BAGEL);
        Filling filling = new Filling("SKU123", 0.8f, "Chocolate", Product.ProductType.FILLING);
        bagel.setFilling(filling);
        customer.addBagelToBasket(bagel);

        assertEquals(14.8f, customer.getBagelPrice(bagel));
        customer.removeBagelFromBasket(bagel);
        assertNotEquals(14.8f, customer.getBagelPrice(bagel));
        assertEquals(-1, customer.getBagelPrice(bagel));
    }

//    @Test
//    public void displayAllFillingsAndPrice() {
//        Customer customer = new Customer(new Basket("", 5), inventory);
//        customer.viewFillingsPrice();
//    }

    @Test
    public void chooseAndRetrieveBagelWithFilling() {
        Customer customer = new Customer(new Basket("", 5), inventory);
        customer.getBagelAndPickFilling("bacon");
        assertEquals(1, customer.getAmountOfBagelsInBasket());
        assertEquals(0.51f, customer.getTotalCost());
    }
}
