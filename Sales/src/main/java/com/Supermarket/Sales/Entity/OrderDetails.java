package com.Supermarket.Sales.Entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer orderNum;
    private Date orderDate;

    private boolean DeliveryStatus;
    @ManyToOne
    private User user;

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

    public boolean isDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }


}
