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
        this.basketType = basketType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Bagel> getBagels() {
        return bagels;
    }

    public void setBagels(ArrayList<Bagel> bagels) {
        this.bagels = bagels;
    }

    public void addBagel(Bagel bagel) {

    }

    public void removeBagel(Bagel bagel) {

    }

    public int getTotalCost() {
        return -1;
    }

}
