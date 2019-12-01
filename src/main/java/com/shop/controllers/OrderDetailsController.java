package com.shop.controllers;

import com.shop.model.Order;
import com.shop.model.OrderDetails;
import com.shop.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/ordersdetails"})
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetails> getDetails() {
        return orderDetailsRepository.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetails add(@RequestBody OrderDetails orderDetails){
        return orderDetailsRepository.save(orderDetails);
    }

}
