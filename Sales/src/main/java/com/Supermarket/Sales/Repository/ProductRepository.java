package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
