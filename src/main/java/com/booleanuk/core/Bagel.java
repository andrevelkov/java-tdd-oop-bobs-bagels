package com.booleanuk.core;

import java.util.List;

public class Bagel {
    private String sku;
    private String name;
    private String variant;
    private int price;
    private Filling filling;
// TODO: fix -> this -> setter methods
    public Bagel(String sku, Filling filling, int price, String variant, String name) {
        this.sku = sku;
        this.filling = filling;
        this.price = price;
        this.variant = variant;
        this.name = name;
    }

    public Bagel() {

    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    public void chooseFilling(List<Filling> fillings){

    }

    public void getFillingCost(List<Filling> fillings) {

    }


}
