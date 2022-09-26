package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.User;
import com.Supermarket.Sales.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


        @GetMapping("/users")
        public List<User> displayUsers()
        {
            return userRepository.findAll();
        }

        //do this based on "demo" proj
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user)
    {
        userRepository.save(user);
        return "User added";
    }

}
