package com.rava.learning.demo;

import com.rava.learning.demo.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController

public class SpringDemoApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringDemoApplication.class, args);



    }



}
