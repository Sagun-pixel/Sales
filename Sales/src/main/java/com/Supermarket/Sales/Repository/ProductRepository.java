package com.Supermarket.Sales.Repository;


import com.Supermarket.Sales.Entity.Product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
   // @Query("Select c.ProductList FROM  Category c where c.categoryTitle=catTitle")
   // public Product findByNameIgnoreCase( String catTitle );

@Query(("SELECT  p,pr FROM  Product p, Price pr"
        + " WHERE p.priceId = pr.priceId AND pr.pricePerItem <= ?1"))
         List<Product> findByPricePerItemLessThan( double pricePerItem);

 /*  public default List<Product> findByPriceLessThan(double pricePerItem) {

      EntityManagerFactory emf = null;
      EntityManager entityManager = emf.createEntityManager();
      Query query = entityManager
              .createQuery("SELECT  p,pr FROM  Product p, Price pr, User u"
                      + " WHERE p.productCode = pr.productCode AND pr.pricePerItem=pricePerItem");
      query.setParameter("pricePerItem",pricePerItem );

      return query.getResultList();}*/
 // List<Product> findByPricePerItemLessThanFromProductAndPrice(double pricePerItem);
   List<Product> findProductByProductName(String productName);

   //List<Product> findByCategoryContainingFromProduct(String categoryTitle);
}
