package com.Supermarket.Sales.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

   public Integer userId;
   private String firstName;
   private String lastName;
   private String phoneNo;
   private String email;
@Column(name= "member")
   private String membershipStatus; //active_inactive
   @Column(name = "since")
   @Temporal(TemporalType.DATE)
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",locale = "en-IN", timezone = "Asia/Kolkata")
   private Date memStartDate;
   @Column(name = "memPts")
   private Integer MemberPoints;
/// @JsonBackReference
//  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "category")
    @JsonBackReference(value = "A")
  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "user")
   private List<Orders> orders;//=new ArrayList<>();

@JsonBackReference(value = "B")
  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "user")
  private List<OrderDetails> orderDetails;//=new ArrayList<>();
   // LocalDate currentDate = LocalDate.now();
/*public int calculateMemPeriod(Date memStartDate, Date currentDate) {
//        // validate inputs ...
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
  //      int d1 = Integer.parseInt(formatter.format(memStartDate));
    //    int d2 = Integer.parseInt(formatter.format(currentDate));
      //  int memPeriod = (d2 - d1) / 10000;
      return memPeriod;
    }*/
//ChronoUnit.MONTHS.between(LocalDate.parse( memStartDate.toString()),LocalDate.parse(memStartDate.toString())

  public int calculateMemberPoints(Date memStartDate, String membershipStatus)//Date memStartDate,String membershipStatus
  {
      LocalDate memStartLocalDate = memStartDate.toInstant()
              .atZone(ZoneId.systemDefault())
              .toLocalDate();
      //This is not the best way for day calculation
      long memPeriod = ChronoUnit.MONTHS.between( memStartLocalDate,LocalDate.now());

      if(membershipStatus.equals("active")) {//companies == null ? 0 : companies.size()
          int count;
          if (this.orders == null) {
              count = 0;
          } else count = orders.size();
          MemberPoints = 10 + 10 * count;//Math.toIntExact,membership creation 10 points
          long i;
          for (i = 0; i < 100; i++) {
              if (memPeriod == 3 * i)
                  MemberPoints = Math.toIntExact(MemberPoints + (50 * i));//50 points every three months
          }
      }

      return MemberPoints;
  }
  //import java.text.DateFormat;
    //import java.text.SimpleDateFormat;
    //import java.time.LocalDate;
    //import java.time.Period;
    //import java.util.Date;
    //
    //class HelloWorld {
    //    public static void main(String[] args) {
    //        System.out.println("Hello, World!");
    //        System.out.println(cal(20000914,20221010));
    //    }
    //
    //        public static int cal(int d1, int d2)
    //        {
    //
    //        int age = (d2 - d1) / 10000;
    //        return age;
    //    }
    //
    //}
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

