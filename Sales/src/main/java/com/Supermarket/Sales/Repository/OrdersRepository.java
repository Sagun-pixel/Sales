package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.OrderDetails;
import com.Supermarket.Sales.Entity.Orders;
import com.Supermarket.Sales.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
