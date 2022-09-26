package com.Supermarket.Sales.Entity;

import javax.persistence.*;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
   public Integer productCode;
@Column(name = "Name")
   private String productName;
@Column(name="Description",length = 3000)
private String productDescription;
  // public String CategoryId;
@Column
private Integer qtyInTotal;
public double pricePerItem;
private double Discount;//memberPoints yes_no,anyPresentOffers

   @ManyToOne
   private Category category;

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   private double DiscountedPrice;

   public Integer getProductCode() {
      return productCode;
   }

   public void setProductCode(Integer productCode) {
      this.productCode = productCode;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public String getProductDescription() {
      return productDescription;
   }

   public void setProductDescription(String productDescription) {
      this.productDescription = productDescription;
   }

  /* public String getCategoryId() {
      return CategoryId;
   }

   public void setCategoryId(String categoryId) {
      CategoryId = categoryId;
   }*/

   public Integer getQtyInTotal() {
      return qtyInTotal;
   }

   public void setQtyInTotal(Integer qtyInTotal) {
      this.qtyInTotal = qtyInTotal;
   }

   public double getPricePerItem() {
      return pricePerItem;
   }

   public void setPricePerItem(double pricePerItem) {
      this.pricePerItem = pricePerItem;
   }

   public double getDiscount() {
      return Discount;
   }

   public void setDiscount(double discount) {
      Discount = discount;
   }

   public double getDiscountedPrice() {
      return DiscountedPrice;
   }

   public void setDiscountedPrice(double discountedPrice) {
      DiscountedPrice = discountedPrice;
   }


}
