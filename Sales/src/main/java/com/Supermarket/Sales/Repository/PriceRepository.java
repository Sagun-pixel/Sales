package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Integer> {
}
