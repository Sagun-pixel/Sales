package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


//-----------------------------------------------------------------------------------------------------------------


}
