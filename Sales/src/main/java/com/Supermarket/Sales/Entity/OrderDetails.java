package com.Supermarket.Sales.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OrderDetails {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer orderNum;
    private Date orderDate;
    private Integer userId;
    private String deliveryStatus;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="userId",insertable=false,updatable=false)
    private User user;

    @OneToOne
    @JoinColumn
    private Orders orders;

    //---------------------------------------------------------------------------------------------------

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
