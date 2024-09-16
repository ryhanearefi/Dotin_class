package com.rava.learning.demo.customer;



import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.time.Month.MAY;
import static java.util.Calendar.APRIL;


@Service
public class CustomerService {


    private final CustomerRepository customerRepository;
    public  final List<Customer> CUSTOMERS = new ArrayList<>(
            List.of(
                    new Customer(
                            1L, "Reyhane", "r_arefy@yahoo.com", LocalDate.of(2000, APRIL, 20), 23),
                    new Customer(
                            2L, "Ali", "arefy61@gmail.com", LocalDate.of(1995, MAY, 20), 30)
            )
    );
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();

    }

    public Customer getCustomerByEmail(String email) {
        return this.customerRepository.findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("Customer with email" + email + " not found")
                );
    }

    @Transactional
    public void addcustomer(CustomerDto customerDto) {
        Customer customer = new Customer(
                customerDto.name(),
                customerDto.email(),
                customerDto.dob()
        );
        this.customerRepository.save(customer);
    }
    @Transactional
    public void editCustomer(Long customerId, CustomerDto customerDto) {
        Customer oldCustomer = customerRepository.findById(customerId)
                 .orElseThrow(
                        () -> new RuntimeException("Customer with id" + customerId + " not found")
                );
       oldCustomer.setName(customerDto.name());
       oldCustomer.setEmail(customerDto.email());
       oldCustomer.setDob(customerDto.dob());
       this.customerRepository.save(oldCustomer);

    }

    @Transactional
    public void deletecustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
