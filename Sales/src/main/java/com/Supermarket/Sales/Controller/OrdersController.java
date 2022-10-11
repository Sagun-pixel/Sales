package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Orders;
import com.Supermarket.Sales.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
@GetMapping("/pullById/{orderNum}")
public Optional<Orders> pullById(@PathVariable Integer orderNum)
{
    return ordersRepository.findById(orderNum);
}

@PostMapping("/addOrder")
public String addOrder(@RequestBody Orders orders)
 {
ordersRepository.save(orders);
    return "Order added";
 }

@PutMapping("updateOrder/{orderNum}")

public String updateOrder(@PathVariable Integer orderNum,@RequestBody Orders orders)
 { Orders updatedOrder=ordersRepository.findById(orderNum).get();
     updatedOrder.setBillAmount(orders.getBillAmount());
     ordersRepository.save(updatedOrder);
     return "Order updated";
 }


}
