package com.booleanuk.core;

import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n");
        // Load inventory on start
        Inventory inv = loadInventoryOnStart();
        List<Product> list = inv.getInventoryList();
        // inv.printInventory();

        Basket basket = new Basket("small", 5);
        Customer customer = new Customer(basket, list);

        Bagel bagel1 = new Bagel("BGLO", 0.49f, "Onion", Product.ProductType.BAGEL);
        Bagel bagel2 = new Bagel("BGLP", 0.39f, "Plain", Product.ProductType.BAGEL);
        Bagel bagel3 = new Bagel("BGLE", 0.49f, "Everything", Product.ProductType.BAGEL);
        Bagel bagel4 = new Bagel("BGLS", 0.49f, "Sesame", Product.ProductType.BAGEL);
        Bagel bagel5 = new Bagel("BGLS", 0.49f, "Sesame", Product.ProductType.BAGEL);
        Bagel bagel6 = new Bagel("BGLS", 0.49f, "Sesame", Product.ProductType.BAGEL);


        // Story 1:
        Time time = Time.valueOf("07:45:00");
        String s = customer.orderBagelAtSpecificTime(time, "everything");
        System.out.println(s);

        // Story 2:
        customer.addBagelToBasket(bagel1);
        customer.removeBagelFromBasket(bagel1);

        // Story 3:
        customer.addBagelToBasket(bagel1);
        customer.addBagelToBasket(bagel2);
        customer.addBagelToBasket(bagel3);
        customer.addBagelToBasket(bagel4);
        customer.addBagelToBasket(bagel5);
        customer.addBagelToBasket(bagel6); // full

        // Story 4:
        Manager manager = new Manager(inv);
        manager.changeBasketCapacity(basket, 10);
        customer.addBagelToBasket(bagel6); // not full anymore

        // Story 5:
        customer.removeBagelFromBasket(bagel1); // should remove
        customer.removeBagelFromBasket(bagel1); // nothing to remove

        // Story 6:
        System.out.println(customer.getTotalCost());

        // Story 7:
        System.out.println(customer.getBagelPrice(bagel4));

        // Story 8 and 9:
        customer.viewFillingsAndPrice();
        customer.getBagelAndPickFilling("cheese");

        // Story 10:
        Bagel test = new Bagel("sku123", 10f, "test", Product.ProductType.BAGEL);
        Bagel test2 = new Bagel("sku999", 10f, "test", Product.ProductType.BAGEL);
        manager.addItemToInv(test);
        customer.addBagelToBasket(test); // should work
        customer.addBagelToBasket(test2); // should not work
    }

    public static Inventory loadInventoryOnStart() {
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

        return inventory;
    }
}
