package com.wfy.service.Impl;

import com.wfy.mapper.ProductMapper;
import com.wfy.pojo.Product;
import com.wfy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> findAllProduct() {
        List<Product> list = productMapper.findAllProduct();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNumber(i+1);
        }
        return list;
    }

    @Override
    public List<Product> findByLimit(int limit) {
        List<Product> list = productMapper.findByLimit(limit);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNumber(i+1);
        }
        return list;
    }

    @Override
    public Product findProductById(int id) {
        Product productById=productMapper.findProductById(id);
        System.out.println(productById);
        return productById;
    }

    @Override
    public void saveProduct(Product product) {
        productMapper.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productMapper.deleteProduct(id);
    }
}
