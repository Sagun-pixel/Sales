package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Category;
import com.Supermarket.Sales.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

//    @Query("Select c.category_productList FROM  Category c where c.categoryTitle=catTitle")
  //  public Product findByNameIgnoreCase(String catTitle);
}