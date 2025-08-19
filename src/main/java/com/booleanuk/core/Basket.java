package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Bagel> bagels = new ArrayList<>();
    private String basketType;
    private int capacity;

    public Basket(String basketType, int capacity) {
        setBasketType(basketType);
        setCapacity(capacity);
    }

    public String getBasketType() {
        return basketType;
    }

    public void setBasketType(String basketType) {
        if (basketType == null || basketType.toLowerCase().trim().isEmpty())
            basketType = "small";

        this.basketType = basketType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0)
            capacity = 5;

        this.capacity = capacity;
    }

    public ArrayList<Bagel> getBagels() {
        return bagels;
    }

    public void setBagels(ArrayList<Bagel> bagels) {
        this.bagels = bagels;
    }

    public void addBagel(Bagel bagel) {
        bagels.add(bagel);
    }

    public void removeBagel(Bagel bagel) {
        bagels.remove(bagel);
    }

    public float getTotalCost() {
        float totCost = 0;
        for (Bagel bagel: bagels)
            totCost += bagel.getPrice();

        return totCost;
    }

}
