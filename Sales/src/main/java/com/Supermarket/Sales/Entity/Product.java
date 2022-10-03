package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Product {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer productCode;
@Column(name = "Name")
   private String productName;
@Column(name="Description",length = 3000)
private String productDescription;
  // public String CategoryId;
@Column
private Integer qtyInTotal;
//public double pricePerItem;
//private double Discount;//memberPoints yes_no,anyPresentOffers
@JsonManagedReference
   @ManyToOne
   @JoinColumn(name = "fk_sNo")
   private Price price;
   @JsonManagedReference
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "fk_categoryId")
   private Category category;
//-----------------------------------------------------------------------------------------------------------------

    public Product() {
    }

    public Product(Integer productCode, String productName, String productDescription, Integer qtyInTotal, Price price, Category category) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.qtyInTotal = qtyInTotal;
        this.price = price;
        this.category = category;
    }

    public Product(String productName, String productDescription, Integer qtyInTotal, Price price, Category category) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.qtyInTotal = qtyInTotal;
        this.price = price;
        this.category = category;
    }

    public Price getPrice() {
      return price;
   }

   public void setPrice(Price price) {
      this.price = price;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }



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


   public Integer getQtyInTotal() {
      return qtyInTotal;
   }

   public void setQtyInTotal(Integer qtyInTotal) {
      this.qtyInTotal = qtyInTotal;
   }

}
