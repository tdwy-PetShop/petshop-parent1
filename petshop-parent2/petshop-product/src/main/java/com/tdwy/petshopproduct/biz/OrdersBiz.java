package com.tdwy.petshopproduct.biz;

import com.tdwy.petshop.bean.*;
import com.tdwy.petshop.dao.OrderitemMapper;
import com.tdwy.petshop.dao.OrdersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrdersBiz {
    @Resource
    CartBiz cartBiz;
    @Resource
    OrdersMapper ordersMapper;
    @Resource
    OrderitemMapper orderitemMapper;

    public Result addOrder(User user) {
        double total = 0;
        double index;
        List<Cart> carts = cartBiz.showCart(user).getData();
        for (Cart c : carts) {
            if (c.getProduct().getDisprice() != null) {
                index = c.getProduct().getDisprice() * c.getCount();
            } else {
                index = c.getProduct().getPrice() * c.getCount();
            }
            total += index;
        }
        Orders orders;
        double tot;
        Orderitem orderitem = new Orderitem();

        SimpleDateFormat dmDate = new SimpleDateFormat("yyyyMMddHHmmss"); // 获取当前时间
        Date date = new Date();
        String dateran = dmDate.format(date) + user.getId();

        Orders oe = new Orders();
        oe.setUid(user.getId());
        oe.setTotal(total);
        oe.setAid(1);
        oe.setOrderid(dateran);
        oe.setCreatetime(date);
        oe.setState(0);
        int code = ordersMapper.insert(oe);
        if (code == 1) {
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andUidEqualTo(user.getId()).andStateEqualTo(0);
            ordersExample.setOrderByClause("id desc");
            orders = ordersMapper.selectByExample(ordersExample).get(0);


            for (Cart c : carts) {
                if (c.getProduct().getDisprice() != null) {
                    tot = c.getProduct().getDisprice() * c.getCount();
                } else {
                    tot = c.getProduct().getPrice() * c.getCount();
                }
                orderitem.setCount(c.getCount());
                orderitem.setOid(orders.getId());
                orderitem.setPid(c.getPid());
                orderitem.setTotal(tot);
                int cod = orderitemMapper.insert(orderitem);
            }
            cartBiz.delAll(user);
            return new Result(1, "添加成功");
        }
        return new Result(0, "系统错误");
    }

    public Result<List<Orders>> showOrders(User user) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andUidEqualTo(user.getId());
        try {
            List<Orders> orders=ordersMapper.selectByExample(ordersExample);
            return new Result<>(1,"查询成功",orders);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(0,"系统错误");
        }
    }

    public Result changeState(int state,String orderid){
        Orders orders=new Orders();
        orders.setState(state);
        orders.setOrderid(orderid);
        int code=ordersMapper.changeState(orders);
        return new Result(1,"修改成功");
    }

    public Result<List<Orders>> showAllOrders(){
        try {
            List<Orders> orders=ordersMapper.selectAll();
            return new Result<>(1,"查询成功",orders);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(0,"系统错误");
        }
    }
}
