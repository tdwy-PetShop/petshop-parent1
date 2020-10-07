package com.tdwy.petshopproduct.biz;

import com.github.pagehelper.PageHelper;
import com.tdwy.petshop.bean.*;
import com.tdwy.petshop.dao.CartMapper;
import com.tdwy.petshop.dao.CategoryMapper;
import com.tdwy.petshop.dao.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ProductBiz {
    @Resource
    ProductMapper productMapper;

    @Resource
    CartMapper cartMapper;
    @Resource
    CategoryMapper categoryMapper;

    /**
     * 展示index主页 Recent Products
     */

    public List<Product> recentProducts() {
        ProductExample productExample = new ProductExample();
        productExample.setOrderByClause("createtime desc");
        PageHelper.startPage(1, 8);
        return productMapper.selectByExample(productExample);
    }

    /**
     * 商品详情
     *
     * @param id
     * @return
     */
    public Product productDetails(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加到购物车cart
     */
    public Result addCart(int pid, int count, User user) {
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andPidEqualTo(pid).andUidEqualTo(user.getId());
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        if (carts.isEmpty()) {
            try {
                Cart cart = new Cart();
                cart.setPid(pid);
                cart.setCount(count);
                cart.setUid(user.getId());
                int code = cartMapper.insert(cart);
                if (code == 1) {
                    return new Result(1, "添加成功");
                } else {
                    return new Result(0, "添加失败");
                }
            } catch (Exception e) {
                return new Result(0, "系统错误");
            }
        } else {
            try {
                Cart cart = carts.get(0);
                cart.setCount(cart.getCount() + count);
                int code = cartMapper.updateByPrimaryKey(cart);
                if (code == 1) {
                    return new Result(1, "添加成功");
                } else {
                    return new Result(0, "添加失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(0, "系统错误");
            }
        }
    }

    /**
     * 查询所有
     */
    public Result<List<Product>> selectAll(){
        ProductExample productExample=new ProductExample();
        productExample.setOrderByClause("hot desc");
        try {
            List<Product> products=productMapper.selectByExample(productExample);
            return new Result<>(1,"查询成功",products);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(0,"系统错误");
        }
    }


}
