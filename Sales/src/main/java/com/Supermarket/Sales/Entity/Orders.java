package com.Supermarket.Sales.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//orderSummary
@Entity
public class Orders {
    @Id
    public Integer orderNum;

    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    private Integer orderQty;
  /*  public double pricePerItem;
    public double discountedPrice;*/
    public double TotalItemPrice;//after discounts n qty ;discountedPrice*qty

   public double BillAmount;

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }



    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
/*
    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
*/
    public double getTotalItemPrice() {
        return TotalItemPrice;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        TotalItemPrice = totalItemPrice;
    }

    public double getBillAmount() {
        return BillAmount;
    }

    public void setBillAmount(double billAmount) {
        BillAmount = billAmount;
    }
}
