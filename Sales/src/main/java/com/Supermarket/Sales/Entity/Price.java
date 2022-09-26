package com.Supermarket.Sales.Entity;

import javax.persistence.*;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int sNo;
    @OneToOne
    private Product product;
    private double memDiscount;
    private double   specialOfferDiscount;
    private double effPrice;

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getMemDiscount() {
        return memDiscount;
    }

    public void setMemDiscount(double memDiscount) {
        this.memDiscount = memDiscount;
    }

    public double getSpecialOfferDiscount() {
        return specialOfferDiscount;
    }

    public void setSpecialOfferDiscount(double specialOfferDiscount) {
        this.specialOfferDiscount = specialOfferDiscount;
    }

    public double getEffPrice() {
        return effPrice;
    }

    public void setEffPrice(double effPrice) {
        this.effPrice = effPrice;
    }
}
