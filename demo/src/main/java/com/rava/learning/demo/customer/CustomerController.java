package com.rava.learning.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.MAY;
import static java.util.Calendar.APRIL;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
  return customerService.getCustomers();
    }
    @GetMapping("{email}")
    Customer getCustomerByEmail(@PathVariable(name = "email") String email) {
        return customerService.getCustomerByEmail(email);
    }

    @PostMapping
    void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addcustomer(customerDto);
    }

    @PutMapping(path="{customer_id}")
    void editCustomer(@PathVariable("customer_id") Long customerId,
                      @RequestBody CustomerDto customerDto) {
         customerService.editCustomer(customerId,customerDto);

    }
    @DeleteMapping(path = "{customer_id}")
    void deleteCustomer(@PathVariable("customer_id") Long customerId) {
        customerService.deletecustomer(customerId);


    }

}
