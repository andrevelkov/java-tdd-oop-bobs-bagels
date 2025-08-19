package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {

    }

    public List<Product> getInventoryList() {
        return this.products;
    }

    public void printInventory() {
        for (Product p : products) {
            System.out.println(p);
//            if (p instanceof Bagel) {
//                System.out.println("ISSA BAGEL");
//            }
        }
    }

}
