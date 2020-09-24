package com.tdwy.petshopindex.IAction;

import com.tdwy.petshop.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product")
public interface IProductAction {
    @GetMapping("recentProducts")
    List<Product> recentProducts();
}
