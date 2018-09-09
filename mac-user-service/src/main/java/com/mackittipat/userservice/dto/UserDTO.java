package com.mackittipat.userservice.dto;

import com.mackittipat.userservice.model.Address;
import com.mackittipat.userservice.model.User;

import java.util.List;

public class UserDTO {

    private User user;
    private List<Address> addressList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
