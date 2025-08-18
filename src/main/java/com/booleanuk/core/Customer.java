package com.booleanuk.core;

import java.sql.Time;
import java.util.List;

public class Customer {
    private Basket basket;

    public Customer(Basket basket) {
        this.basket = basket;
    }

    public void addBagelToBasket(Bagel bagel) {

    }

    public void removeBagelFromBasket(Bagel bagel) {

    }

    public void viewTotalCost() {

    }

    public void viewBagelPrice() {

    }

    public int selectFillings(int option) {

        return -1;
    }

    public void viewFillingsPrice(List<Filling> fillings) {

    }

    public String orderBagelAtSpecificTime(Time time) {

        return "Order: " + time + ", Bagel: ";
    }

    public int returnBasketCapacity() {
        return this.basket.getBagels().size();
    }

}
