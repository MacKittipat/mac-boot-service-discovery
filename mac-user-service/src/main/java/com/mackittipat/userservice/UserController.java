package com.mackittipat.userservice;

import com.mackittipat.userservice.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll() {

        User user = new User();
        user.setUsername("mac");

        User user2 = new User();
        user2.setUsername("ronaldo");

        User user3 = new User();
        user3.setUsername("neymar");

        return Arrays.asList(user, user2, user3);
    }

}
