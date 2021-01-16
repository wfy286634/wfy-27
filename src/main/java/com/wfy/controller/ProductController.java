package com.wfy.controller;


import com.wfy.pojo.Product;
import com.wfy.pojo.User;
import com.wfy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAllProduct")
    @ResponseBody
    public List<Product> findAllProduct() {
        List<Product> list = productService.findAllProduct();
        return list;
    }

    @RequestMapping("/saveProduct")
    @ResponseBody
    public boolean saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return true;
    }

    @RequestMapping("/updateProduct")
    @ResponseBody
    public boolean updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return true;
    }

    @RequestMapping("/deleteProduct")
    @ResponseBody
    public void deleteProduct(@RequestBody User user){
        productService.deleteProduct(user.getId());
    }

    @RequestMapping("/findProductById")
    @ResponseBody
    public Product findProductById(@RequestBody Product product) {
        System.out.println(product.getId());
        Product productById =productService.findProductById(product.getId());
        return productById;
    }
}
