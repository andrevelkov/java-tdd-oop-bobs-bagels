package com.booleanuk.core;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Basket basket = null;

    public Customer(Basket basket) {
        this.basket = basket;
    }

    public void addBagelToBasket(Bagel bagel) {
        basket.addBagel(bagel);
    }

    public void removeBagelFromBasket(Bagel bagel) {
        basket.removeBagel(bagel);
    }

    public float getTotalCost() {
        ArrayList<Bagel> bagels = basket.getBagels();

        float totCost = 0;
        for (Bagel bagel : bagels)
            totCost += bagel.getPrice();

        return totCost;
    }

    public float getBagelPrice(Bagel bagel) {
        ArrayList<Bagel> bagels = basket.getBagels();
        for (Bagel b : bagels)
            if (b.getSku().equals(bagel.getSku()))
                return b.getPrice();

        return -1;
    }

    public int selectFillings(int option) {

        return -1;
    }

    public void viewFillingsPrice(List<Filling> fillings) {

    }

    public String orderBagelAtSpecificTime(Time time, Bagel bagel) {
        return "Order: " + time + ", Bagel: " + bagel.toString();
    }

    public int getAmountOfBagelsInBasket() {
        return this.basket.getBagels().size();
    }

}
