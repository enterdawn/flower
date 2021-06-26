package ent;

import dao.*;

public class flower {
    private int id;
    private String name;
    private String color;
    private float price;
    private int store;
    private int stock;
    private int saled;

    public int getSaled() {
        return new daoFactory().getInstance().getDaoFlower().getflowerasled(id);
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getStore() {
        return store;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
