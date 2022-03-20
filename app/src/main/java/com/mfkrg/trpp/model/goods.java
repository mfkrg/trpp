package com.mfkrg.trpp.model;

public class goods {

    int id;
    String name, cost, img, color;

    public goods(int id, String name, String cost, String img, String color) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.img = img;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
