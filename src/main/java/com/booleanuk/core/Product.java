package com.booleanuk.core;

public abstract class Product {
    private String sku;
    private float price;
    private String variant;
    private ProductType type;

    public Product(String sku, float price, String variant, ProductType type) {
        setSku(sku);
        setPrice(price);
        setVariant(variant);
        this.type = type;
    }

    // Getters and setters
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        if (price == 0f || price < 0f) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Enum<ProductType> getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Product [SKU=" + sku + ", Price=" + price + ", Variant=" + variant + "]";
    }

    public enum ProductType {
        FILLING, BAGEL, COFFEE;
    }
}
