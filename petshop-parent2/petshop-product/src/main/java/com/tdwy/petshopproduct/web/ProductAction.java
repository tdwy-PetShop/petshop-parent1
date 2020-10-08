package com.tdwy.petshopproduct.web;

import com.tdwy.petshop.bean.*;
import com.tdwy.petshop.dao.CartMapper;
import com.tdwy.petshopproduct.biz.*;
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
    @Resource
    CategoryBiz categoryBiz;
    @Resource
    OrdersBiz ordersBiz;
    @Resource
    ProCommBiz proCommBiz;


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

    @GetMapping("showCategory")
    public Result<List<Category>> showCategory(){
        return categoryBiz.showCategory();
    }

    @PostMapping("showProductCate")
    public Result<List<Product>> showProductCate(@RequestParam int id){
        return categoryBiz.showProductCate(id);
    }
    /**
     * 提交订单
     */
    @PostMapping("addOrders")
    public Result addOrders(@RequestBody User user){
        return ordersBiz.addOrder(user);
    }

    /**
     * 商品评论
     */
    @PostMapping("addComm")
    public Result addComm(@RequestBody User user,@RequestParam int pid,@RequestParam String content){
        return proCommBiz.addComm(user,pid,content);
    }

    /**
     * 展示订单
     *
     */
    @PostMapping("showOrders")
    public Result<List<Orders>> showOrders(@RequestBody User user){
        return ordersBiz.showOrders(user);
    }

    @GetMapping("changeState")
    public Result changeState(@RequestParam int state,@RequestParam String orderid){
        return ordersBiz.changeState(state,orderid);
    }

    @PostMapping("showAllOrders")
    public Result<List<Orders>> showAllOrders(){
       return ordersBiz.showAllOrders();
    }
}
