package com.Supermarket.Sales.Entity;

import javax.persistence.*;
import java.util.List;

//orderSummary
@Entity
public class Orders {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer orderNum;

 //  @OneToOne
 //   private Product product;
    @ManyToOne
    private User user;


   public double BillAmount;
@OneToMany
    private List<Cart> cartItems;
@OneToOne
private OrderDetails orderDetails;

//-------------------------------------------------------------------------------------------------------------------
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
        return BillAmount;
    }

    public void setBillAmount(double billAmount) {
        BillAmount = billAmount;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
