package com.tdwy.petshopproduct.biz;

import com.tdwy.petshop.bean.ProComm;
import com.tdwy.petshop.bean.Result;
import com.tdwy.petshop.bean.User;
import com.tdwy.petshop.dao.ProCommMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ProCommBiz {
    @Resource
    ProCommMapper proCommMapper;

    public Result addComm(User user,int pid,String content){
        if (content.isEmpty() || content.trim().isEmpty()){
            return new Result(0,"添加失败");
        }else {
            ProComm proComm=new ProComm();
            proComm.setPid(pid);
            proComm.setUid(user.getId());
            proComm.setContent(content);
            proComm.setCreatetime(new Date());
            proCommMapper.insert(proComm);
            return new Result(1,"评论成功");
        }
    }
}
