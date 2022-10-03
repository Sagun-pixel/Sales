package com.Supermarket.Sales.Entity;

import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)


   public Integer userId;
   private String firstName;
   private String lastName;
   private String phoneNo;
   private String email;
@Column(name= "member")
   private String membershipStatus; //active_inactive
   @Column(name = "since")
   private Date memStartDate;
   @Column(name = "memPts")
   private Integer MemberPoints;


  @OneToMany
   private List<Orders> orders=new ArrayList<>();

  @OneToMany
  private List< OrderDetails> orderDetails=new ArrayList<>();
  //-----------------------------------------------------------------------------------------
   public User() {
   }

   public Integer getUserId() {
      return userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getMembershipStatus() {
      return membershipStatus;
   }

   public void setMembershipStatus(String membershipStatus) {
      this.membershipStatus = membershipStatus;
   }

   public Date getMemStartDate() {
      return memStartDate;
   }

   public void setMemStartDate(Date memStartDate) {
      this.memStartDate = memStartDate;
   }

   public Integer getMemberPoints() {
      return MemberPoints;
   }

   public void setMemberPoints(Integer memberPoints) {
      MemberPoints = memberPoints;
   }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", membershipStatus='" + membershipStatus + '\'' +
                ", memStartDate=" + memStartDate +
                ", MemberPoints=" + MemberPoints +
                ", orders=" + orders +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

