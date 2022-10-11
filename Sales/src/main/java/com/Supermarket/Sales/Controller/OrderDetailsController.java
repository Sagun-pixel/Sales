package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.OrderDetails;
import com.Supermarket.Sales.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
@RestController
public class OrderDetailsController {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @GetMapping("/getOrderDetailsByOrderNum/{orderNum}")
    private OrderDetails orderDetailsByOrderNum(@PathVariable Integer orderNum)
    {
        return orderDetailsRepository.findWhereOrderNumIs(orderNum);
    }

    @GetMapping("/ordersOnDate/{orderDate}")
    private OrderDetails ordersOnDate(@PathVariable Date orderDate)
    {
        return orderDetailsRepository.ordersByDate(orderDate);
    }

@GetMapping("/getDeliveryStatus/{orderNum}")
    private OrderDetails displayDeliveryStatus(@PathVariable Integer orderNum)
{
    return orderDetailsRepository.getDeliverStatus(orderNum);
}

@PutMapping("/updateDeliveryStatus/{orderNum}")
    private String updateDetails(@PathVariable Integer orderNum ,@RequestBody OrderDetails orderDetails)
{
    OrderDetails UpdatedOrderDetails=orderDetailsRepository.findById(orderNum).get();
    UpdatedOrderDetails.setDeliveryStatus(orderDetails.getDeliveryStatus());
   orderDetailsRepository.save(UpdatedOrderDetails);
    return "Delivery status changed from 'not delivered' to 'delivered'";
}




}
