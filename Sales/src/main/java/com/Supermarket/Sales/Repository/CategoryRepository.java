package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
