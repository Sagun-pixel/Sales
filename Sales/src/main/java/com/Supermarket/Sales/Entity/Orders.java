package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

//orderSummary
@Entity
public class Orders {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Integer orderNum;
    @Column
    private Integer userId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="userId",insertable=false,updatable=false)
    private User user;

@Column
   public double billAmount;
@OneToMany(mappedBy = "orders")
@JsonBackReference
    private List<Cart> cartItems;
//@OneToOne
//@JsonBackReference
//private OrderDetails orderDetails;

//-------------------------------------------------------------------------------------------------------------------

    public Orders() {
    }

    public Orders(Integer orderNum, Integer userId, User user, double billAmount, List<Cart> cartItems) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.user = user;
        this.billAmount = billAmount;
        this.cartItems = cartItems;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }


 /*   public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }*/
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<Cart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Cart> cartItems) {
        this.cartItems = cartItems;
    }


    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "orderNum=" + orderNum +
                ", userId=" + userId +
                ", user=" + user +
                ", billAmount=" + billAmount +
                ", cartItems=" + cartItems +
                '}';
    }
}
