package com.booleanuk.core;

import java.util.List;

public class Bagel extends Product {
    private Filling filling;

    public Bagel(String sku, float price, String variant) {
        super(sku, price, variant);

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

    public void chooseFilling(List<Filling> fillings){

    }

    public float getFillingCost() {
        return (this.filling != null) ? this.filling.getPrice() : 0f;
    }

//    public int getBagelTotPrice() {
//        return 0;
//    }

    @Override
    public String toString() {
        return this.getVariant();
    }
}
