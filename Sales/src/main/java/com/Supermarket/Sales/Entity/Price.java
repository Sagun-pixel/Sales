package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
public class Price {
    @Id
            // @GeneratedValue(strategy = GenerationType.IDENTITY)
     public int sNo;
    public double pricePerItem;
    @JsonBackReference
    @OneToMany
    @JoinColumn(name = "fk_sNo",referencedColumnName = "sNo")
    private List<Product> productList= new ArrayList<>();

    private double memDiscount;
    private double specialOfferDiscount;
    private double effPrice;
//---------------------------------------------------------------------------------------------------------------------


    public Price() {
    }

    public Price(int sNo, double pricePerItem, List<Product> productList, double memDiscount, double specialOfferDiscount, double effPrice) {
        this.sNo = sNo;
        this.pricePerItem = pricePerItem;
        this.productList = productList;
        this.memDiscount = memDiscount;
        this.specialOfferDiscount = specialOfferDiscount;
        this.effPrice = effPrice;
    }

    public Price(double pricePerItem, List<Product> productList, double memDiscount, double specialOfferDiscount, double effPrice) {
        this.pricePerItem = pricePerItem;
        this.productList = productList;
        this.memDiscount = memDiscount;
        this.specialOfferDiscount = specialOfferDiscount;
        this.effPrice = effPrice;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

  /*  public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }*/

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
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }


}
