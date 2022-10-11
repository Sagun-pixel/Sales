package com.Supermarket.Sales.Repository;

import com.Supermarket.Sales.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface OrderDetailsRepository extends JpaRepository <OrderDetails,Integer> {
    @Query("Select o FROM OrderDetails o where o.orderDate=date")
    public OrderDetails ordersByDate(Date date);

    @Query("Select o.deliveryStatus from OrderDetails o where o.orderNum=orderNum")
    public OrderDetails getDeliverStatus(Integer orderNum);

    @Query("Select o from OrderDetails o where o.orderNum=orderNum")
    public OrderDetails findWhereOrderNumIs(Integer orderNum);


}
