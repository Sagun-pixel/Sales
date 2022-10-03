package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Category;
import com.Supermarket.Sales.Entity.Product;


import com.Supermarket.Sales.Repository.CategoryRepository;
import com.Supermarket.Sales.Repository.PriceRepository;
import com.Supermarket.Sales.Repository.ProductRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;//dependency injection
   @Autowired
   private CategoryRepository categoryRepository;
   @Autowired
   private PriceRepository priceRepository;


 /*   @GetMapping(value = "/displayProducts", produces= MediaType.APPLICATION_JSON_VALUE)
    public String displayProducts(){
        return "Go to 1./displayAllProd 2./prodById/{id} 3./prodByCat";
    }*/
    @GetMapping(value="/displayAllProd")//,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Product> displayAllProd() {
        return productRepository.findAll();
    }

    @GetMapping("/prodById/{productCode}")
    public Optional<Product> getUser(@PathVariable int productCode){
        return productRepository.findById(productCode);
    }

    @PostMapping("/addProduct")
    public String addProd(@RequestBody Product product)
    {
        productRepository.save(product);
        return ("Product added");}
    //@PostMapping("/saveEmployees")
    //    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData)
    //    {
    //        employeeRepository.saveAllAndFlush(empData);
    //        return ResponseEntity.ok("Data saved");


   /* @GetMapping("/prodByCat/{categoryTitle}")
    public Product prodByCat(@PathVariable String categoryTitle)
    {
        return categoryRepository.findByNameIgnoreCase(categoryTitle);    }*/

   /*reference

    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id)
    { Exp4User deleteUser=Exp4UserInterface.findById(id).get();
        Exp4UserInterface.delete(deleteUser);
        return"Delete user with the id"+id;


    }*/
}
