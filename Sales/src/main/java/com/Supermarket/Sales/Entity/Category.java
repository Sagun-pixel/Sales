package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
//@Transactional
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Category {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer categoryId;
    @Column//(name="Title")
    public String categoryTitle;
    @Column//(name ="Description",length = 3000)
    private String categoryDescription;
  // private Integer productCode;

  // @ManyToMany(cascade = CascadeType.PERSIST)
//@JsonManagedReference
  // @JoinColumn(name="productCode",updatable = false)
//@JoinColumn(name="productList",insertable = false,updatable = false)
    //  private List<Product> productList ;//=new HashSet<Product>();
  @JsonBackReference
  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "category")
  private List<Product> productList;

//-----------------------------------------------------------------------------------------------------------

    public Category() {
    }

    public Category(Integer categoryId, String categoryTitle, String categoryDescription, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
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


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}
