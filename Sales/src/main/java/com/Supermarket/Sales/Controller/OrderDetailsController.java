package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.OrderDetails;
import com.Supermarket.Sales.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;
@RestController
public class OrderDetailsController {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @GetMapping("/ordersOnDate/{orderDate}")
    private OrderDetails ordersOnDate(@PathVariable Date orderDate)
    {
        return orderDetailsRepository.ordersByDate(orderDate);
    }







    //getDeliveryStatus

}
