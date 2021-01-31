package com.wfy.service.Impl;

import com.wfy.mapper.CustomerMapper;
import com.wfy.pojo.Customer;
import com.wfy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> allCustomer = customerMapper.findAllCustomer();
        for (int i = 0; i < allCustomer.size(); i++) {
            allCustomer.get(i).setNumber(i+1);
        }
        return allCustomer;
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerMapper.findCustomerById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerMapper.saveCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerMapper.deleteCustomer(id);
    }

    @Override
    public List<Customer> findByLimit(int limit) {
        List<Customer> allCustomer = customerMapper.findAllCustomerByLimit(limit);
        for (int i = 0; i < allCustomer.size(); i++) {
            allCustomer.get(i).setNumber(i+1);
        }
        return allCustomer;
    }
}
