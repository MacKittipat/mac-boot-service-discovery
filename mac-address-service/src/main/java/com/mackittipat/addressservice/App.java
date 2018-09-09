package com.mackittipat.addressservice;

import com.mackittipat.addressservice.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    private Map<Integer, Address> addressMap = new HashMap<>();

    {
        Address address = new Address();
        address.setId(1);
        address.setLocaiton("Bangkok");

        Address address2 = new Address();
        address2.setId(2);
        address2.setLocaiton("Madrid");

        Address address3 = new Address();
        address3.setId(3);
        address3.setLocaiton("Paris");

        Address address4 = new Address();
        address4.setId(4);
        address4.setLocaiton("Lisbon");

        Address address5 = new Address();
        address5.setId(5);
        address5.setLocaiton("Oslo");

        Address address6 = new Address();
        address6.setId(6);
        address6.setLocaiton("Munic");

        addressMap.put(address.getId(), address);
        addressMap.put(address2.getId(), address2);
        addressMap.put(address3.getId(), address3);
        addressMap.put(address4.getId(), address4);
        addressMap.put(address5.getId(), address5);
        addressMap.put(address6.getId(), address6);
    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/addresses/{id}", method = RequestMethod.GET)
    public Address findById(@PathVariable Integer id) {
        log.info("Finding address id : {}", id);
        return addressMap.get(id);
    }
}
