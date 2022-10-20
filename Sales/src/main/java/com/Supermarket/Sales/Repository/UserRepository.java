package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,Integer> {


}
