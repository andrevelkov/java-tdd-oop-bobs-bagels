package com.booleanuk.core;

public class Filling {
    private float price;
    private String sku;
    private String variant;

    public Filling(float price, String sku, String variant) {
        setPrice(price);
        setSku(sku);
        setVariant(variant);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

}