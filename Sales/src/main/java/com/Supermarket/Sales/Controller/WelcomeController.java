package com.Supermarket.Sales.Controller;
//starterClass
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcomeClass()
    { return "welcome";}
}
