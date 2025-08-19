package com.booleanuk.core;

import java.util.List;

public class TestHelper {

    public List<Product> loadInventoryOnStart() {
        // Add all items to the inventory
        Inventory inventory = new Inventory();
        // Add Bagels
        inventory.addProduct(new Bagel("BGLO", 0.49f, "Onion", Product.ProductType.BAGEL));
        inventory.addProduct(new Bagel("BGLP", 0.39f, "Plain", Product.ProductType.BAGEL));
        inventory.addProduct(new Bagel("BGLE", 0.49f, "Everything", Product.ProductType.BAGEL));
        inventory.addProduct(new Bagel("BGLS", 0.49f, "Sesame", Product.ProductType.BAGEL));

        // Add Fillings
        inventory.addProduct(new Filling("FILB", 0.12f, "Bacon", Product.ProductType.FILLING));
        inventory.addProduct(new Filling("FILE", 0.12f, "Egg", Product.ProductType.FILLING));
        inventory.addProduct(new Filling("FILC", 0.12f, "Cheese", Product.ProductType.FILLING));
        inventory.addProduct(new Filling("FILX", 0.12f, "Cream Cheese", Product.ProductType.FILLING));
        inventory.addProduct(new Filling("FILS", 0.12f, "Smoked Salmon", Product.ProductType.FILLING));
        inventory.addProduct(new Filling("FILH", 0.12f, "Ham", Product.ProductType.FILLING));

        // Add Coffees

        return inventory.getInventoryList();
    }

}
