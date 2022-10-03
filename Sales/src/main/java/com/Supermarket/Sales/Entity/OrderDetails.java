package com.Supermarket.Sales.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OrderDetails {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer orderDetailsNum;
    private Date orderDate;

    private boolean deliveryStatus;
    @ManyToOne()
    private User user;

    @OneToOne
    private Orders orders;

    //---------------------------------------------------------------------------------------------------

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getOrderDetailsNum() {
        return orderDetailsNum;
    }

    public void setOrderDetailsNum(Integer orderDetailsNum) {
        this.orderDetailsNum = orderDetailsNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
