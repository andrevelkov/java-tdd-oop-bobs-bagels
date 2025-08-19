package com.booleanuk.core;


public class Manager {
    private Inventory inventory;

    public Manager(Inventory inventory) {
        this.inventory = inventory;
    }

    public void changeBasketCapacity(Basket basket, int num) {
        basket.setCapacity(num);
    }

    public void addItemToInv(Product product) {
        inventory.addProduct(product);
    }

    public void removeItemToInv(Product product) {
        inventory.removeProduct(product);
    }

}