package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Cart;
import com.Supermarket.Sales.Entity.Category;
import com.Supermarket.Sales.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
@Autowired
private CategoryRepository categoryRepository;
@GetMapping("/getCat")
public List<Category> getCat()
{
    return categoryRepository.findAll();
}

    @PostMapping("/addCat")
    public String addCat(@RequestBody Category category)
    {
        categoryRepository.save(category);
        return"New Category created";
    }
    @PutMapping("/updateCat/{categoryId}")
    public String updateCat(@PathVariable Integer categoryId, @RequestBody Category category)
    {
        Category updatedCategory=categoryRepository.findById(categoryId).get();
        updatedCategory.setCategoryDescription(category.getCategoryDescription());
        updatedCategory.setCategoryTitle(category.getCategoryTitle());
       // updatedCategory.setProductList(category.getProductList());
        categoryRepository.save(updatedCategory);
        return "Category details updated";

    }
    @DeleteMapping("/deactivateCat/{categoryId}")
    public String deleteCat(@PathVariable Integer categoryId)
    { Category deleteCat=categoryRepository.findById(categoryId).get();
        categoryRepository.delete(deleteCat);
        return "Deactivate category with category id"+categoryId;}
}
