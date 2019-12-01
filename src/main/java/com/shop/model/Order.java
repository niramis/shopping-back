package com.shop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "ORDER_PRODUCTS",
//            joinColumns = {@JoinColumn(name = "ORDER_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID")})
////    @JsonManagedReference
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "order", targetEntity = OrderDetails.class, cascade = CascadeType.ALL)
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
//    @MapsId()
    private Set<OrderDetails> orderDetails;

//    @Column(name="USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "testcase_id", nullable=true, referencedColumnName = "id")
    @JoinColumn(name = "USER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_USR_FK"), referencedColumnName = "id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private DAOUser user;

    @Column(name = "ORDER_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    private OrderStatus status;

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DAOUser getUser() {
        return user;
    }

    public void setUser(DAOUser user) {
        this.user = user;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    //    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
