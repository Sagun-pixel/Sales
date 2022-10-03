package com.Supermarket.Sales.Repository;


import com.Supermarket.Sales.Entity.Product;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
  // @Query("Select c.ProductList FROM  Category c where c.categoryTitle=catTitle")
   // public Product findByNameIgnoreCase( String catTitle );

}
