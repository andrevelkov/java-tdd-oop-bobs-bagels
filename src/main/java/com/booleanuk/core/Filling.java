package com.booleanuk.core;

public class Filling {
    private String id;
    private int price;
    private String sku;
    private String variant;

    public Filling(String id, int price, String sku, String variant) {
        setId(id);
        setPrice(price);
        setSku(sku);
        setVariant(variant);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

}