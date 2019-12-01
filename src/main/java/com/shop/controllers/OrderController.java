package com.shop.controllers;

import com.shop.model.Order;
import com.shop.model.OrderDetails;
import com.shop.model.OrderStatus;
import com.shop.model.Product;
import com.shop.repository.OrderDetailsRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@RequestMapping({"/orders"})
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

//    @Autowired
//    private ProductRepository productRepository;

//    @Autowired
//    AddressRepository addressRepository;
//
//    @Autowired
//    EmpRepository empRepository;

//    @GetMapping(path = "addemp")
//    public void addemp(){
//        Address address1 = new Address("Bengaluru", "Karnataka", "India", "560016");
//        Address address2 = new Address("Jaipur", "Rajasthan", "India", "302017");
//
//        // Employee1 have 2 addresses
//        Emp employee1 = new Emp("Ravindra Singh", "Sales Manager", 450000);
//        employee1.getAddresses().add(address1);
//        employee1.getAddresses().add(address1);
//        employee1.getAddresses().add(address2);
//
//        // Employee2 have 1 address
//        Emp employee2 = new Emp("Mohit Sharma", "Software Engineer", 850000);
//        employee2.getAddresses().add(address1);
//
//        empRepository.save(employee1);
//        empRepository.save(employee2);
//    }

//    @PostMapping(path = "addemp")
//    public void addemp2(@RequestBody Emp emp){
//        empRepository.save(emp);
//    }
//
//    @GetMapping(path = "showemp")
//    public List<Emp> showemp(){
//        return empRepository.findAll();
//    }

    @GetMapping(produces = "application/json")
    public List<Order> getOrders() {

        return (List<Order>) orderRepository.findAll();
    }

    @Transactional
    @PostMapping(path = "/add")
    public Order addOrder(@RequestBody Order order) {
        order.setStatus(OrderStatus.STATE1);

        for (OrderDetails orderDetails: order.getOrderDetails()){
            orderDetails.setOrder(order);
            orderDetailsRepository.save(orderDetails);
        }

        return orderRepository.save(order);
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    public Order getOrder(@PathVariable("id") int id) {
        return orderRepository.findById(id).get();
    }

    @GetMapping(produces = "application/json", path = "/user/{id}")
    public List<Order> getOrdersforUser(@PathVariable("id") Long id) {
        return orderRepository.getUsersOrdersById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/state2")
    public ResponseEntity<Order> setOrderState2(@RequestBody Order order) {
        Order o = orderRepository.findById(order.getId()).get();
        o.setStatus(OrderStatus.STATE2);
        return ResponseEntity.ok(orderRepository.save(o));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "state3")
    public ResponseEntity<Order> setOrderState3(@RequestBody Order order) {
        Order o = orderRepository.findById(order.getId()).get();
        o.setStatus(OrderStatus.STATE3);
        return ResponseEntity.ok(orderRepository.save(o));
    }


//    @GetMapping(produces = "application/json", path = "/user/{id}")
//    public List<Order> getOrdersForUserById(@PathVariable("id") long id) {
//        return orderRepository.getUserOrdersById(id);
//    }
//
//    @GetMapping(produces = "application/json", path = "/user/{id}")
//    public List<Order> getOrdersForUser(@PathVariable("id") long id) {
//        return orderRepository.getUserOrdersById(id);
//    }
}
