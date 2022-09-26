package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
