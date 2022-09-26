package com.Supermarket.Sales.Entity;

import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.Date;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)


   public Integer userId;
   private String firstName;
   private String lastName;
   private String PhoneNo;
   private String email;
@Column(name= "member")
   private String membershipStatus; //active_inactive
   @Column(name = "since")
   private Date memStartDate;
   @Column(name = "memPts")
   private Integer MemberPoints;

   @OneToMany
   private OrderDetails orderDetails;
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
      return PhoneNo;
   }

   public void setPhoneNo(String phoneNo) {
      PhoneNo = phoneNo;
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

   @Override
   public String toString() {
      return "User{" +
              "userId=" + userId +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", PhoneNo='" + PhoneNo + '\'' +
              ", email='" + email + '\'' +
              ", membershipStatus='" + membershipStatus + '\'' +
              ", memStartDate=" + memStartDate +
              ", MemberPoints=" + MemberPoints +
              '}';
   }
}
