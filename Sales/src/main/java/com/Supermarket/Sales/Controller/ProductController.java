package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Category;
import com.Supermarket.Sales.Entity.Product;

import com.Supermarket.Sales.Repository.CategoryRepository;
import com.Supermarket.Sales.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProductController {
    @Autowired
    private ProductRepository productRepository;//dependency injection
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/displayProducts")
    public String displayProducts(){
        return "Go to 1./displayAllProd 2./prodById/{id} 3./prodByCat";
    }
    @GetMapping("/displayAllProd")
    public List<Product> displayAllProd() {
        return productRepository.findAll();
    }

    @GetMapping("prodById/{id}")
    public Optional<Product> getUser(@PathVariable int productCode){
        return productRepository.findById(productCode);
    }
    @GetMapping("prodByCat/{categoryId}")
    public Optional<Category> prodByCat(@PathVariable int categoryId){
        return categoryRepository.findById(categoryId);
    }
   /*reference

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody Exp4User exp4User) {
        Exp4User updatedUser = Exp4UserInterface.findById(id).get();
        updatedUser.setFirstName(exp4User.getFirstName());
        updatedUser.setLastName(exp4User.getLastName());
        updatedUser.setAge(exp4User.getAge());
        updatedUser.setOccupation(exp4User.getOccupation());
        Exp4UserInterface.save(updatedUser);
        return "Updated...";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id)
    { Exp4User deleteUser=Exp4UserInterface.findById(id).get();
        Exp4UserInterface.delete(deleteUser);
        return"Delete user with the id"+id;


    }*/
}
