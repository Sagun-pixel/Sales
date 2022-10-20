package com.Supermarket.Sales.Controller;
import com.Supermarket.Sales.Entity.Product;


import com.Supermarket.Sales.Repository.CategoryRepository;
import com.Supermarket.Sales.Repository.PriceRepository;
import com.Supermarket.Sales.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

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

    @GetMapping(value="/displayAllProd")//,produces= (MediaType.APPLICATION_JSON_VALUE)
    public List<Product> displayAllProd() {
        return productRepository.findAll();
    }

    @GetMapping("/prodById/{productCode}")
    public Optional<Product> getUser(@PathVariable int productCode){
        return productRepository.findById(productCode);
    }
    //private List<Product> productList=new CopyOnWriteArrayList<>();
    @PostMapping("/addProduct")
    public String addProd(@RequestBody Product product)
    {
        productRepository.save(product);
        return ("Product added");}

    @GetMapping("/findByProductName/{productName}")
    public List<Product> findProductsContainingByName(@PathVariable String productName){
        return productRepository.findProductByProductName(productName);
    }

    @GetMapping("/findByPrice/{pricePerItem}")
    public List<Product> findProductsLessThanPrice(@PathVariable double pricePerItem) {
        return  productRepository.findByPricePerItemLessThan(pricePerItem);
    }


        // do something with entities

@PutMapping("/updateProductDetails/{productCode}")
public String updateProduct(@PathVariable Integer productCode,@RequestBody Product product)
{ Product updatedProduct=productRepository.findById(productCode).get();
    updatedProduct.setQtyInTotal(product.getQtyInTotal());
    productRepository.save(updatedProduct);
    return "Product details updated";
}

@DeleteMapping("/deactivateProduct/{productCode}")
public String deleteProduct(@PathVariable Integer productCode)
{ Product deactivateProduct=productRepository.findById(productCode).get();
    productRepository.delete(deactivateProduct);
    return "Deactivate product with the id"+productCode;}
}
        //@PostMapping("/saveEmployees")
        //    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData)
        //    {
        //        employeeRepository.saveAllAndFlush(empData);
        //        return ResponseEntity.ok("Data saved");}


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

