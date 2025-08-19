package com.booleanuk.core.Products;

public class Bagel extends Product {
    private Filling filling;

    public Bagel(String sku, float price, String variant, ProductType type) {
        super(sku, price, variant, type);

        setPrice(price);
    }

    public void setPrice(float price) {
        if (price <= 0)
            throw new IllegalArgumentException("Price must be more than 0");

        super.setPrice(price);
    }

    @Override
    public float getPrice() {
        if (filling != null)
            return super.getPrice() + filling.getPrice();
        else
            return super.getPrice();
    }

    public Filling getFilling() {
        return this.filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    public float getFillingCost() {
        return (this.filling != null) ? this.filling.getPrice() : 0f;
    }

    @Override
    public String toString() {
        return this.getVariant();
    }
}
