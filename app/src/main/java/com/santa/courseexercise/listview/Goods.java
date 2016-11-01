package com.santa.courseexercise.listview;

/**
 * Created by jsd58 on 10/26/2016.
 */

public class Goods {


    private int src;
    private String Price;
    private String Name;
    private String Notice;

    public Goods(long id, String name, String notice, String price, int src) {
        this.id = id;
        Name = name;
        Notice = notice;
        Price = price;
        this.src = src;
    }

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
