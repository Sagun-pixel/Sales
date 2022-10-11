package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Product;
import com.Supermarket.Sales.Entity.User;
import com.Supermarket.Sales.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

        user.setMemberPoints(user.calculateMemberPoints(user.getMemStartDate(),user.getMembershipStatus()));
        userRepository.save(user);

        return "User added";
    }
    @GetMapping("/userById/{userId}")
    public String userById(@PathVariable Integer userId)
    {
        //"More than one user can have the same name,it was a good call to use the user id to access data "+
       String s1= (userRepository.findById(userId)).toString();
       return "More than one user can have the same name,it was a good call to use the user id to access data"+s1;


    }
    @PutMapping("/updateUserDetails/{userId}")
    public String updateUser(@PathVariable Integer userId,@RequestBody User user)
    { User updatedUser=userRepository.findById(userId).get();
        updatedUser.setMembershipStatus(user.getMembershipStatus());
        updatedUser.setPhoneNo(user.getPhoneNo());
        userRepository.save(updatedUser);
        return "User details updated";
    }

    @DeleteMapping("/deactivateUser/{userId}")
    public String deleteUser(@PathVariable Integer userId)
    { User deactivateUser=userRepository.findById(userId).get();
        userRepository.delete(deactivateUser);
        return "Deactivate User with the id"+userId;}



    //String s1 = help.toString();
   // String s2 = String.valueOf(help);

}
