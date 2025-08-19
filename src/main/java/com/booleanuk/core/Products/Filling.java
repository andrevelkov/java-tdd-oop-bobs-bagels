package com.booleanuk.core.Products;

public class Filling extends Product {

    public Filling(String sku, float price, String variant, ProductType type) {
        super(sku, price, variant, type);

        setPrice(price);
        setSku(sku);
    }

    public float getPrice() {
        return super.getPrice();
    }

    public void setPrice(float price) {
        if (price < 0)
            price = 1f;
        super.setPrice(price);
    }

    public String getSku() {
        return super.getSku();
    }

    public void setSku(String sku) {
        if (sku.toUpperCase().trim().isEmpty())
            sku = "FIL";

        String upperCase = sku.toUpperCase().trim();

        super.setSku(upperCase);
    }

    public String getVariant() {
        return super.getVariant();
    }

    public void setVariant(String variant) {
        if (variant.trim().isEmpty())
            variant = "plain";

        super.setVariant(variant);
    }

    @Override
    public String toString() {
        return this.getVariant();
    }
}