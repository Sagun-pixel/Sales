package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.User;
import com.Supermarket.Sales.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/userById/{id}")
    public String userById(@PathVariable Integer userId)
    {
        //"More than one user can have the same name,it was a good call to use the user id to access data "+
       String s1= (userRepository.findById(userId)).toString();
       return "More than one user can have the same name,it was a good call to use the user id to access data"+s1;


    }
    //String s1 = help.toString();
   // String s2 = String.valueOf(help);

}
