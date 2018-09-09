package com.mackittipat.userservice;

import com.mackittipat.userservice.dto.UserDTO;
import com.mackittipat.userservice.model.Address;
import com.mackittipat.userservice.model.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    private Map<Integer, User> userMap = new HashMap<>();

    {
        User user = new User();
        user.setId(1);
        user.setUsername("mac");
        user.setAddressIdList(Arrays.asList(1, 3));

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("ronaldo");
        user2.setAddressIdList(Arrays.asList(2));

        User user3 = new User();
        user3.setId(3);
        user3.setUsername("neymar");
        user3.setAddressIdList(Arrays.asList(4, 5, 6));

        userMap.put(user.getId(), user);
        userMap.put(user2.getId(), user2);
        userMap.put(user3.getId(), user3);
    }

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDTO findById(@PathVariable Integer id) {
        log.info("Finding user id : {}", id);
        User user = userMap.get(id);

        List<Address> addressesList = new ArrayList<>();
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("ADDRESS-SERVICE", false);
        for(Integer addressId : user.getAddressIdList()) {
            String url = instance.getHomePageUrl() + "addresses/" + addressId;
            log.info("Finding address of user id {} at {}", id, url);
            Address address = restTemplate.getForObject(url, Address.class);
            log.info("Address of user id {} is {}", id, address);
            addressesList.add(address);
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUser(user);
        userDTO.setAddressList(addressesList);

        return userDTO;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll() {
        log.info("Finding all user");
        return new ArrayList<>(userMap.values());
    }
}
