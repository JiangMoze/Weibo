package com.moze.service;

import com.moze.dao.WeiboDao;
import com.moze.vo.Weibo;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/9.
 */
public class WeiboService {
    private WeiboDao dao=new WeiboDao();
    public boolean addWeibo(Weibo weibo){
        return dao.addWeibo(weibo);

    }
    public List<Weibo> qurryAll(){
        return  dao.queryMessage();
    }
    public boolean delWeibo(int id){
        return dao.delWeibo(id);
    }
}
