package com.tdwy.petshopindex.IAction;

import com.tdwy.petshop.bean.Cart;
import com.tdwy.petshop.bean.Product;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "product")
public interface IProductAction {
    @GetMapping("recentProducts")
    List<Product> recentProducts();

    @PostMapping("productDetails")
    Product productDetails(@RequestParam int id);

    @PostMapping("addCart")
    Result addCart(@RequestParam int pid, @RequestParam int count ,@RequestBody User user);

    @PostMapping("showCart")
    Result<List<Cart>> showCart(@RequestBody User user);
}
