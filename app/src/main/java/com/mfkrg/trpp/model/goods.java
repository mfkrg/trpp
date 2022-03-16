package com.mfkrg.trpp.model;

public class goods {

    int id;
    String img, title, cost, color;

    public goods(int id, String img, String title, String cost, String color) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.cost = cost;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
