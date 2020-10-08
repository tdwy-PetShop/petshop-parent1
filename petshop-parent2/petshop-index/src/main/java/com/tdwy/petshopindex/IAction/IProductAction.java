package com.tdwy.petshopindex.IAction;

import com.tdwy.petshop.bean.*;
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

    @GetMapping("showCategory")
    Result<List<Category>> showCategory();

    @PostMapping("showProductCate")
    Result<List<Product>> showProductCate(@RequestParam int id);

    @PostMapping("addOrders")
    Result addOrders(@RequestBody User user);

    @PostMapping("addComm")
    Result addComm(@RequestBody User user,@RequestParam int pid,@RequestParam String content);

    @PostMapping("showOrders")
    Result<List<Orders>> showOrders(@RequestBody User user);

    @GetMapping("changeState")
    Result changeState(@RequestParam int state,@RequestParam String orderid);

    @PostMapping("showAllOrders")
    Result<List<Orders>> showAllOrders();
}
