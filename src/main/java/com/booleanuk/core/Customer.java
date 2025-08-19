package com.booleanuk.core;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Basket basket = null;
//    private Inventory inventory = null;
    private List<Product> products = null;

    public Customer(Basket basket, List<Product> inventory) {
        this.basket = basket;
        this.products = inventory;
    }

    public void addBagelToBasket(Bagel bagel) {
        for (Product p: products)
            if (p.getSku().equals(bagel.getSku())) {
                if (basket.addBagel(bagel)) {
                    System.out.println("Added to basket.");
                    break;
                } else
                    System.out.println("Basket is full, you cant add more bagelZ");
            }
    }

    public void removeBagelFromBasket(Bagel bagel) {
        if (basket.removeBagel(bagel))
            System.out.println("Bagel removed from basket");
        else
            System.out.println("Nothing to remove.");
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

    public void viewFillingsAndPrice() {
        for (Product product: products)
            if (product.getType() == Product.ProductType.FILLING) {
                System.out.printf("Filling: %-20s --> %.2f SEK\n", product.getVariant(), product.getPrice());
            }
    }

    public Bagel getBagelAndPickFilling(String filling){
        Filling fill = (Filling) products.stream()
                .filter(product -> product.getType() == Product.ProductType.FILLING &&
                        product.getVariant().equalsIgnoreCase(filling.trim()))
                .map(product -> (Filling) product).findFirst().orElse(null);

        Bagel bagel = (Bagel) products.stream()
                .filter(product -> product.getType() == Product.ProductType.BAGEL &&
                        product.getVariant().equalsIgnoreCase("plain"))
                .map(product -> (Bagel) product).findFirst().orElse(null);

        if (bagel != null && fill != null)
            bagel.setFilling(fill);
            basket.addBagel(bagel);
            System.out.printf("Bagel with %s added. \n", fill.getVariant());

//        bagel.setFilling(fill);
//        basket.addBagel(bagel);

        return bagel;
    }

    public String orderBagelAtSpecificTime(Time time, String bagelType) {

        Bagel bagel = (Bagel) products.stream().filter(product -> product.getVariant()
                                      .equalsIgnoreCase(bagelType))
                                      .map(product -> (Bagel) product).findFirst().orElse(null);

        return (bagel != null) ? "Order: " + time + ", Bagel: " + bagel.toString() : "Camon little boy";
    }

    public int getAmountOfBagelsInBasket() {
        return this.basket.getBagels().size();
    }

}
