package com.shop.repository;

import com.shop.model.Category;
import com.shop.model.Order;
import com.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    List<Product> getProductsByName(String name);

    @Query(value = "select p from Product p where p.price BETWEEN :price1 AND :price2")
    List<Product> getAllBetweenPrices(@Param("price1") double price1, @Param("price2") double price2);

    @Query("SELECT p FROM Product p")
    List<Product> getProductsByCategory(String category);

}
