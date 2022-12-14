package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer productCode;
@Column//(name = "Name")
   private String productName;
@Column//(name="Description",length = 3000)
private String productDescription;
@Column
private Integer qtyInTotal;
private Integer priceId;
private Integer categoryId;


   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name="priceId",insertable=false,updatable=false)
   private Price price;

//try many to many later
  // @JsonBackReference
 //@ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "productList")
 // private List<Category> categories;//=new HashSet<Category>();//private Set<Author> authors = new HashSet<Author>();
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name="categoryId",insertable=false,updatable=false)
private Category category;

   @ManyToMany(mappedBy = "products")
   @JsonBackReference
   private List<Cart> carts ;
  // @ManyToMany(cascade = CascadeType.ALL)
   //@JoinTable(name="cart_prod", joinColumns=@JoinColumn(name="productCode"), inverseJoinColumns=@JoinColumn(name = "userId"))
   //private List<Cart> carts;

 // @ManyToOne(cascade = CascadeType.PERSIST)
 // @JoinColumn(insertable=false,updatable=false)
   //@JoinColumn
 //  private Cart cart;
/* @NotNull
 @ManyToOne(fetch = FetchType.LAZY, optional = false)
 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
 private Cart cart;*/
//-----------------------------------------------------------------------------------------------------------------


}
