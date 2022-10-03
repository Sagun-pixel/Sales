package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
public class Category {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer categoryId;
    @Column//(name="Title")
    public String categoryTitle;
    @Column//(name ="Description",length = 3000)
    private String categoryDescription;
   @JsonBackReference
@OneToMany
@JoinColumn(name = "fk_categoryId",referencedColumnName = "categoryId")
    private List<Product> productList= new ArrayList<>();
//-----------------------------------------------------------------------------------------------------------


    public Category() {
    }

    public Category(String categoryTitle, String categoryDescription, List<Product> productList) {
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        this.productList = productList;
    }

    public Category(Integer categoryId, String categoryTitle, String categoryDescription, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
