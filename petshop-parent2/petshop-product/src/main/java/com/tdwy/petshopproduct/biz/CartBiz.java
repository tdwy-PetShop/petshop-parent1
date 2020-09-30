package com.tdwy.petshopproduct.biz;

import com.tdwy.petshop.bean.Cart;
import com.tdwy.petshop.bean.CartExample;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;
import com.tdwy.petshop.dao.CartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartBiz {
    @Resource
    CartMapper cartMapper;

    public Result<List<Cart>> showCart(User user) {
        CartExample cartExample=new CartExample();
        cartExample.createCriteria().andUidEqualTo(user.getId());
        try {
            List<Cart> cartList=cartMapper.selectByExample(cartExample);
            return new Result<>(1, "查询成功", cartList);
        }catch (Exception e){
            return new Result<>(0,"系统错误");
        }

    }
}
