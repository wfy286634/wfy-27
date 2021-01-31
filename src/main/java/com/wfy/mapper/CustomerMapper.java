package com.wfy.mapper;

import com.wfy.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {

    List<Customer> findAllCustomer();

    Customer findCustomerById (int id);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

    List<Customer> findAllCustomerByLimit(int limit);

    int customerCount();

}
