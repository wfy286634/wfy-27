package com.wfy.service;

import com.wfy.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    List<Product> findByLimit(int limit);

    Product findProductById (int id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

}
