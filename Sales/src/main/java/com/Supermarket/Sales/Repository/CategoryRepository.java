package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Category;
import com.Supermarket.Sales.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("Select p.productCode,p.productName FROM Product p, Category c "+ "WHERE p.categoryId=c.categoryId AND c.categoryTitle = :categoryTitle")
    List<Object> findProductListByCategoriesCategoryTitle(String categoryTitle);
 //   @Query("Select p.productName FROM Product p, Category c "+ "WHERE p.categoryId=c.categoryId AND c.categoryTitle = :categoryTitle")
  //  List<String> findProductListByCategoriesCategoryTitle(String categoryTitle);

//    @Query("Select c.category_productList FROM  Category c where c.categoryTitle=catTitle")
  //  public Product findByNameIgnoreCase(String catTitle);
}