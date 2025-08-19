package com.booleanuk.core;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class InventoryTest {

    @Test
    public void testAddProductToInventory() {
        Inventory inventory = new Inventory();
        Product product = new Bagel("ABC123", 99.99f, "Red", Product.ProductType.BAGEL);

        inventory.addProduct(product);
        List<Product> products = inventory.getInventoryList();
        assertEquals(1, products.size());  // 1 product in the inventory
        assertEquals(product, products.get(0));  //
    }

    @Test
    public void testGetInventoryList() {
        Inventory inventory = new Inventory();
        Product product1 = new Bagel("ABC123", 99.99f, "Red", Product.ProductType.BAGEL);
        Product product2 = new Bagel("DEF456", 29.99f, "Blue", Product.ProductType.BAGEL);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        List<Product> products = inventory.getInventoryList();
        assertEquals(2, products.size());  // 2 products
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }

    @Test
    public void testRemoveProductFromInventory() {
        Inventory inventory = new Inventory();
        Product product1 = new Bagel("ABC123", 99.99f, "Red", Product.ProductType.BAGEL);
        Product product2 = new Bagel("DEF456", 29.99f, "Blue", Product.ProductType.BAGEL);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.removeProduct(product1);

        List<Product> products = inventory.getInventoryList();
        assertEquals(1, products.size());  // 1 product
        assertFalse(products.contains(product1));  // false
        assertTrue(products.contains(product2));  // true
    }
}

