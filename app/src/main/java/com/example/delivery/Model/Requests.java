package com.example.delivery.Model;

import java.util.List;

public class Requests {
    private String phone;
    private String address;
    private String name;
    private int Total;
    private String Status;
    private List<Order> foods; // list of Food Order
    private String uid;
    private String latLng;

    public Requests() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLatLng() {
        return latLng;
    }

    public void setLatLng(String latLng) {
        this.latLng = latLng;
    }

    public Requests(String phone, String address, String name, int total, String status, List<Order> foods, String uid, String latLng) {
        this.phone = phone;
        this.address = address;
        this.name = name;
        Total = total;
        Status = status;
        this.foods = foods;
        this.uid = uid;
        this.latLng = latLng;
    }
}
