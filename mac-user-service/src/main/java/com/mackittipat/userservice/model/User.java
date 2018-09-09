package com.mackittipat.userservice.model;

import java.util.List;

public class User {

    private int id;
    private String username;
    private List<Integer> addressIdList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getAddressIdList() {
        return addressIdList;
    }

    public void setAddressIdList(List<Integer> addressIdList) {
        this.addressIdList = addressIdList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", addressIdList=" + addressIdList +
                '}';
    }
}
