package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository <OrderDetails,Integer> {
}
