package com.wfy.controller;

import com.wfy.pojo.Customer;

import com.wfy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/findAllCustomer")
    @ResponseBody
    public List<Customer> findAllCustomer() {
        List<Customer> list = customerService.findAllCustomer();
        return list;
    }

    @RequestMapping("/saveCustomer")
    @ResponseBody
    public boolean saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return true;
    }

    @RequestMapping("/updateCustomer")
    @ResponseBody
    public boolean updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return true;
    }

    @RequestMapping("/deleteCustomer")
    @ResponseBody
    public void deleteCustomer(@RequestBody Customer customer){
        customerService.deleteCustomer(customer.getId());
    }

    @RequestMapping("/findCustomerById")
    @ResponseBody
    public Customer findCustomerById(@RequestBody Customer customer) {
        Customer customerById = customerService.findCustomerById(customer.getId());
        return customerById;
    }
}
