package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Cart;
import com.Supermarket.Sales.Entity.Price;
import com.Supermarket.Sales.Entity.Product;
import com.Supermarket.Sales.Entity.User;
import com.Supermarket.Sales.Repository.CartRepository;
import com.Supermarket.Sales.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private  CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;


    // private Logger logger = LoggerFactory.getLogger(CartController.class);//to get info about errors
    //<dependency>
    //			<groupId>org.slf4j</groupId>
    //			<artifactId>slf4j-api</artifactId>
    //
    //		</dependency>

    @GetMapping("/getCartItems")
    public List<Cart> getCartItems()
    {  return cartRepository.findAll();}



    @PostMapping("/addItemsToCart")
    public String addItemsToCart(@RequestBody Cart  cart)
    {
        cartRepository.save(cart);
        return "Item added to cart";
    }


/*@PutMapping("/updateQty/{userId}")
public String updateProductQty(@PathVariable Integer userId, @RequestBody Cart cart)
    {
        Cart updatedCart = cartRepository.findById(userId).get();
        updatedCart.setProductQty(cart.getProductQty());
        cartRepository.save(updatedCart);
        return "Updated...";
    }*/

    @PutMapping("/AddToCart/userId/{userId}/productNo/{productCode}")
    public Cart addProductToCart(@PathVariable Integer userId, @PathVariable Integer productCode) {

        Cart cart = cartRepository.findById(cartRepository.findByCartIdContaining(userId)).get();
        Product product = productRepository.findById(productCode).get();
        cart.addProduct(product);
        return cartRepository.save(cart);
    }


    // @DeleteMapping("/removeCartItem")
   @DeleteMapping("/EmptyCart/{userId}")
   public String removeCartItem(@PathVariable Integer userId)
   { Cart removeCartItem=cartRepository.findById(userId).get();
       cartRepository.delete(removeCartItem);
       return "Deactivate cart item with product code"+userId;}

    //removeCartProduct

}

