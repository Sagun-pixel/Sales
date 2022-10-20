package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    public void addProduct(Product product)
    {
        products.add(product);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    private Integer userId;

  //  @GeneratedValue(strategy = GenerationType.IDENTITY)//how to increment with rows deleted
  //  public int serialNo;
    private int productQty;
    public double totalItemPrice;//after discounts n qty ;discountedPrice*qty
    private Integer productCode;

    //@OneToMany
   // @JoinColumn(name = "productCode",insertable = false,updatable = false)
   // @JsonBackReference
   //Associations marked as mappedBy must not define database
    // mappings like @JoinTable or @JoinColumn: com.Supermarket.Sales.Entity.Cart.product
   // private List<Product> product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    @JsonIgnore
    private Orders orders;

    @OneToOne
    @JoinColumn(name = "userId",updatable = false,insertable = false)
    private User user;//every user has a cart ,once transaction is done the cart is emptied
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="cart_prod", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name = "productCode"))
    private  List<Product> products=new ArrayList();
//-----------------------------------------------------------------------------------------------------------

    public Cart() {
    }

    public Cart(Integer cartId, Integer userId, int productQty, double totalItemPrice, Integer productCode, Orders orders, User user, List<Product> products) {
        this.cartId = cartId;
       this.userId = userId;
        this.productQty = productQty;
        this.totalItemPrice = totalItemPrice;
        this.productCode = productCode;
        this.orders = orders;
        this.user = user;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public double getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
