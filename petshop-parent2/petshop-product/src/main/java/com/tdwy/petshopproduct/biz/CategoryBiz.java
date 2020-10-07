package com.tdwy.petshopproduct.biz;

import com.tdwy.petshop.bean.Category;
import com.tdwy.petshop.bean.CategoryExample;
import com.tdwy.petshop.bean.Product;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.dao.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryBiz {
    @Resource
    CategoryMapper categoryMapper;

    public Result<List<Category>> showCategory(){
        CategoryExample categoryExample=new CategoryExample();
        categoryExample.createCriteria().andPidIsNull();
        try {
            List<Category> categoryList= categoryMapper.selectByExample(categoryExample);
            List<Category> cl;
            for (Category c:categoryList){
                cl=categoryMapper.selectByPid(c.getId());
                if (!cl.isEmpty()){
                    c.setChildren(cl);
                }
            }
            return new Result<>(1,"查询成功",categoryList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(0,"系统错误");
        }
    }

    /**
     * 分类查询
     * @param id
     * @return
     */
    public Result<List<Product>> showProductCate(int id){

        try {
            Category c=categoryMapper.selectByPrimaryKey(id);
            if (c.getPid()==null){
                List<Category> cl=categoryMapper.selectByPid(c.getId());
                for (Category cg : cl){
                    c.getProducts().addAll(cg.getProducts());
                }
            }
            return new Result<>(1,"查询成功",c.getProducts());
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(0,"系统错误");
        }
    }
}
