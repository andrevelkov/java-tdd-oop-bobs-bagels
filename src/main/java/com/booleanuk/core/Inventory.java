package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getInventoryList() {
        return this.products;
    }

    public Product getProduct(Product.ProductType type, String variant) {
        for (Product p: products)
            if (p.getType() == type && p.getVariant().toLowerCase().equals(variant.toLowerCase().trim()))
                return p;
        return null;
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
