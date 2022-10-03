package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Price;
import com.Supermarket.Sales.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<Price,Integer> {

 // @Query("Select p.price_productList FROM  Price p where p.pricePerItem=price")
 // public Product findByPrice(double price);
}
