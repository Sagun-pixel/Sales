package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.Cart;
import com.Supermarket.Sales.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
   @Query(("SELECT  c.cartId FROM User u, Cart c" + " WHERE c.userId = u.userId AND c.userId = ?1"))

    public Integer findByCartIdContaining(Integer userId);
}
