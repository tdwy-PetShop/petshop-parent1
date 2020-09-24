package com.tdwy.petshopproduct.biz;

import com.github.pagehelper.PageHelper;
import com.tdwy.petshop.bean.Product;
import com.tdwy.petshop.bean.ProductExample;
import com.tdwy.petshop.dao.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductBiz {
    @Resource
    ProductMapper productMapper;
    /**
     * 展示index主页 Recent Products
     */

    public List<Product> recentProducts(){
        ProductExample productExample= new ProductExample();
        productExample.setOrderByClause("createtime desc");
        PageHelper.startPage(1,8);
        return productMapper.selectByExample(productExample);
    }
}
