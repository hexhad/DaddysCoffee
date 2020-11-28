package com.hashan.springb.model;

public class Coffee {
    private int id;
    private int order;
    private int price;
    private String name;
    private String desc;
    private String img;


    public Coffee() {
    }

    public Coffee(int id, int order, int price, String name, String desc, String img) {
        this.id = id;
        this.order = order;
        this.price = price;
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
