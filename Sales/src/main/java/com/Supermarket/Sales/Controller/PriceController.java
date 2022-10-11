package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Category;
import com.Supermarket.Sales.Entity.Price;
import com.Supermarket.Sales.Entity.Product;
import com.Supermarket.Sales.Repository.PriceRepository;
import com.Supermarket.Sales.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PriceController {
    @Autowired
    private PriceRepository priceRepository;
   // @Autowired
  //  private ProductRepository productRepository;

//    "1./prodByPrice/{pricePerItem} 2./updatePrice 3./deactivatePrice ";}

@GetMapping("/viewPrice")
public List<Price> viewPrice()
{
    return priceRepository.findAll();

}
@PostMapping("/activatePrice")
public String activatePrice(@RequestBody Price price)
{
    priceRepository.save(price);
    return"Price Activated";}


 /*   @GetMapping("/prodByPrice/{pricePerItem}")
    public Product prodByCat(@PathVariable double pricePerItem)
    {
        return priceRepository.findByPrice(pricePerItem);    }*/
    @PutMapping("/updatePrice/{productCode}")
    public String  updatePrice(@PathVariable Integer productCode, @RequestBody Price price)
    {
        Price updatedPrice = priceRepository.findById(productCode).get();
        updatedPrice.setPricePerItem(price.getPricePerItem());
        updatedPrice.setMemDiscount(price.getMemDiscount());
        updatedPrice.setSpecialOfferDiscount(price.getSpecialOfferDiscount());
        updatedPrice.setEffPrice(price.getEffPrice());
        priceRepository.save(updatedPrice);
        return "Updated...";}
    @DeleteMapping("/deactivatePrice/{priceId}")
    public String deactivatePrice(@PathVariable Integer priceId)
    { Price deactivatePrice=priceRepository.findById(priceId).get();
        priceRepository.delete(deactivatePrice);
        return "Deactivate price with price id"+priceId;}


}
