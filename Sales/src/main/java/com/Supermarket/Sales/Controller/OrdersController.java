package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Orders;
import com.Supermarket.Sales.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;
@GetMapping("/listOfOrders")
    public List<Orders>getList()
{
    return ordersRepository.findAll();
}
//pull by id, update



}
