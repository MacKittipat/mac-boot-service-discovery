package com.mackittipat.userservice.model;

public class Address {

    private int id;
    private String locaiton;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public void setLocaiton(String locaiton) {
        this.locaiton = locaiton;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", locaiton='" + locaiton + '\'' +
                '}';
    }
}
