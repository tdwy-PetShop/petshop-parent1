package com.tdwy.petshopproduct.web;

import com.tdwy.petshop.bean.*;
import com.tdwy.petshop.dao.CartMapper;
import com.tdwy.petshopproduct.biz.CartBiz;
import com.tdwy.petshopproduct.biz.ProductBiz;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ProductAction {
    @Resource
    ProductBiz productBiz;
    @Resource
    CartBiz cartBiz;


    @GetMapping("recentProducts")
    public List<Product> recentProducts() {
        return productBiz.recentProducts();
    }

    @PostMapping("productDetails")
    public Product productDetails(@RequestParam int id) {
        return productBiz.productDetails(id);
    }

    /**
     * 添加到购物车
     * @SessionAttribute("loginedUser") User user
     *
     * @return
     */
    @PostMapping("addCart")
    public Result addCart(@RequestParam int pid,@RequestParam int count,@RequestBody User user ){
        return productBiz.addCart(pid,count,user);
    }
    @PostMapping("showCart")
    public Result<List<Cart>> showCart(@RequestBody User user){
        return cartBiz.showCart(user);
    }
}
