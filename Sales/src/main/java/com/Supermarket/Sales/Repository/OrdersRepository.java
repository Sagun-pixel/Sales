package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
