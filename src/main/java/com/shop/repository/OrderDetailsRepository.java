package com.shop.repository;

import com.shop.model.Order;
import com.shop.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
