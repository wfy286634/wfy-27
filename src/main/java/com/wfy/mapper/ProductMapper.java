package com.wfy.mapper;


import com.wfy.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {

    List<Product> findAllProduct();

    Product findProductById (int id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
