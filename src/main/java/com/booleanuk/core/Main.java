package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        // Load inventory on start
        loadInventoryOnStart(inventory);
        inventory.printInventory();



    }

    public static void loadInventoryOnStart(Inventory inventory) {
        // Add all items to the inventory

        // Add Bagels
        inventory.addProduct(new Bagel("BGLO", 0.49f, "Onion"));
        inventory.addProduct(new Bagel("BGLP", 0.39f, "Plain"));
        inventory.addProduct(new Bagel("BGLE", 0.49f, "Everything"));
        inventory.addProduct(new Bagel("BGLS", 0.49f, "Sesame"));

        // Add Fillings
        inventory.addProduct(new Filling("FILB", 0.12f, "Bacon"));
        inventory.addProduct(new Filling("FILE", 0.12f, "Egg"));
        inventory.addProduct(new Filling("FILC", 0.12f, "Cheese"));
        inventory.addProduct(new Filling("FILX", 0.12f, "Cream Cheese"));
        inventory.addProduct(new Filling("FILS", 0.12f, "Smoked Salmon"));
        inventory.addProduct(new Filling("FILH", 0.12f, "Ham"));

        // Add Coffees
    }
}
