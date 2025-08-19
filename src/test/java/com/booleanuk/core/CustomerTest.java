package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.Filling;
import com.booleanuk.core.Products.Product;
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

        Bagel bagel = new Bagel("BGLP", 0.39f, "Plain", Product.ProductType.BAGEL);

        customer.addBagelToBasket(new Bagel("BGLO", 0.49f, "Onion", Product.ProductType.BAGEL));
        customer.addBagelToBasket(new Bagel("BGLP", 0.39f, "Plain", Product.ProductType.BAGEL));
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
        Bagel bagel = new Bagel("BGLP", 0.39f, "Plain", Product.ProductType.BAGEL);
        customer.addBagelToBasket(bagel);
        Time time = Time.valueOf("10:00:00");
        assertEquals("Order: 10:00:00, Bagel: Plain", customer.orderBagelAtSpecificTime(time, "plain"));
    }

    @Test
    public void getCorrectTotalCostOfCustomerBasket() {
        Customer customer = new Customer(new Basket("", 5), inventory);
        customer.addBagelToBasket(new Bagel("BGLP", 0.39f, "Plain", Product.ProductType.BAGEL));
        customer.addBagelToBasket(new Bagel("BGLO", 0.49f, "Onion", Product.ProductType.BAGEL));

        Bagel bagel = new Bagel("BGLO", 0.49f, "Onion", Product.ProductType.BAGEL);
        Filling filling = new Filling("SKU123", 0.8f, "Chocolate", Product.ProductType.FILLING);
        bagel.setFilling(filling);
        customer.addBagelToBasket(bagel);

        assertEquals(2.17f, customer.getTotalCost());
        customer.removeBagelFromBasket(bagel);
        assertEquals(0.8799999952316284, customer.getTotalCost());
    }

    @Test
    public void getSingleBagelPriceFromBasket() {
        Customer customer = new Customer(new Basket("", 5), inventory);
        customer.addBagelToBasket(new Bagel("BGLO", 0.49f, "Onion", Product.ProductType.BAGEL));
        customer.addBagelToBasket(new Bagel("BGLO", 0.49f, "Onion", Product.ProductType.BAGEL));

        Bagel bagel = new Bagel("BGLE", 0.49f, "Everything", Product.ProductType.BAGEL);
        Filling filling = new Filling("SKU123", 0.8f, "Chocolate", Product.ProductType.FILLING);
        bagel.setFilling(filling);
        customer.addBagelToBasket(bagel);

        assertEquals(1.29f, customer.getBagelPrice(bagel));
        customer.removeBagelFromBasket(bagel);
        assertNotEquals(0.98f, customer.getBagelPrice(bagel));
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
