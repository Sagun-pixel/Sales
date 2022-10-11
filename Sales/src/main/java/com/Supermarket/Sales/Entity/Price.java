package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     public Integer priceId;
    public double pricePerItem;
    //private Integer productCode;
  @JsonBackReference
   @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "price")
  private List<Product> productList;

    private double memDiscount;
    private double specialOfferDiscount;
    private double effPrice;

  /*  public void calculateMemDiscount(Integer MemberPoints)
    {
        //
        if(MemberPoints<500)
        {
            memDiscount=
        }

    }*/
//---------------------------------------------------------------------------------------------------------------------


    public Price() {
    }

    public Price(Integer priceId, double pricePerItem, List<Product> productList, double memDiscount, double specialOfferDiscount, double effPrice) {
        this.priceId = priceId;
        this.pricePerItem = pricePerItem;
        this.productList = productList;
        this.memDiscount = memDiscount;
        this.specialOfferDiscount = specialOfferDiscount;
        this.effPrice = effPrice;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }



    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
