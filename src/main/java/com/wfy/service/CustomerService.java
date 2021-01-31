package com.wfy.service;

import com.wfy.pojo.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomer();

    Customer findCustomerById (int id);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

    List<Customer> findByLimit(int limit);
}
