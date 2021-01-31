package com.wfy.controller;


import com.wfy.mapper.ProductMapper;
import com.wfy.pojo.Product;
import com.wfy.pojo.User;
import com.wfy.service.ProductService;
import com.wfy.utils.ToolsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ToolsUtil toolsUtil;

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

    /**
     * @Author wfy
     * @Description: 分页查询商品
     * @param map
     * @return List<Product>
     * @Date 17:32 2021/01/29
     **/
    @RequestMapping("/findProductByLimit")
    @ResponseBody
    public List<Product> findByLimit(@RequestBody Map map) {
        System.out.println(map.get("limit"));
        int limit = (int) map.get("limit");
        if(limit<1){
            limit=0;
        }else{
            limit=(limit-1)*10;
        }
        List<Product> result = productService.findByLimit(limit);
        return result;
    }

    /**
     * @Author wfy
     * @Description: 获取数据页数
     * @param
     * @return Map
     * @Date 16:04 2021/01/30
     **/
    @RequestMapping("/getProductPages")
    @ResponseBody
    public Map getCustomerPages() {
        int productCount = productMapper.productCount();
        int pages = toolsUtil.dataPages(productCount);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("pages", pages);
        map.put("productTotal", productCount);
        return map;
    }

}
