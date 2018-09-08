package com.mackittipat.userservice;

import com.mackittipat.userservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll() {

        log.info("Finding all user");

        User user = new User();
        user.setUsername("mac");

        User user2 = new User();
        user2.setUsername("ronaldo");

        User user3 = new User();
        user3.setUsername("neymar");

        return Arrays.asList(user, user2, user3);
    }

}
