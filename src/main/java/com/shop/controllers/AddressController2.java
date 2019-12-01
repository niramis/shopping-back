//package com.shop.controllers;
//
//import com.shop.model.Address;
//import com.shop.repository.AddressRepository2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "address2")
//public class AddressController2 {
//
//    @Autowired
//    private AddressRepository2 addressRepository2;
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addAddress() {
//        Address address = new Address("city1", "state1", "country1", "zip");
//        addressRepository2.save(address);
//    }
//
//}
