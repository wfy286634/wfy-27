package com.wfy.controller;

import com.wfy.mapper.CustomerMapper;
import com.wfy.pojo.Customer;
import com.wfy.service.CustomerService;
import com.wfy.utils.ToolsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ToolsUtil toolsUtil;

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

    /**
     * @Author wfy
     * @Description: 分页查询顾客
     * @param map
     * @return List<Customer>
     * @Date 23:07 2021/01/30
     **/
    @RequestMapping("/findCustomerByLimit")
    @ResponseBody
    public List<Customer> findByLimit(@RequestBody Map map) {
        int limit = (int) map.get("limit");
        if(limit<1){
            limit=0;
        }else{
            limit=(limit-1)*10;
        }
        List<Customer> result = customerService.findByLimit(limit);
        return result;
    }

    /**
     * @Author wfy
     * @Description: 获取数据页数
     * @param
     * @return Map
     * @Date 16:04 2021/01/30
     **/
    @RequestMapping("/getCustomerPages")
    @ResponseBody
    public Map getCustomerPages() {
        int customerCount = customerMapper.customerCount();
        int pages = toolsUtil.dataPages(customerCount);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("pages", pages);
        map.put("customerTotal", customerCount);
        return map;
    }

}
