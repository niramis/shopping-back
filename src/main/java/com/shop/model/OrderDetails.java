package com.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @EmbeddedId
//    @Column(name = "ORDER_DETAILS_ID")
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(cascade = {CascadeType.MERGE})
//    @JoinColumn(name = "ORDER_ID", nullable = false, //
//            foreignKey = @ForeignKey(name = "ORDER_ID"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
//    @JsonBackReference
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne(optional = false, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "PRODUCT_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "PRODUCT_ID"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
//    @JsonBackReference
    private Product product;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn (name="profesor_id",referencedColumnName="id",unique=true)

    @Column(name = "Quantity", nullable = false)
    private int quanity;

//    @Column(name = "Price", nullable = false)
//    private double price;

//    @Column(name = "Amount", nullable = false)
//    private double amount;


    public OrderDetails() {
    }

    public OrderDetails(int id, Order order, Product product, int quanity) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quanity = quanity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return id == that.id &&
                quanity == that.quanity &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, product, quanity);
    }
}
