package com.tdwy.petshopproduct.web;

import com.tdwy.petshop.bean.Product;
import com.tdwy.petshopproduct.biz.ProductBiz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductAction {
    @Resource
    ProductBiz productBiz;

    @GetMapping("recentProducts")
    public List<Product> recentProducts() {
        return productBiz.recentProducts();
    }
}
