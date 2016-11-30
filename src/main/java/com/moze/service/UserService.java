package com.moze.service;

import com.moze.dao.UserDao;
import com.moze.vo.User;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/6.
 */
public class UserService {
    private UserDao dao=new UserDao();
    public User login(User user) {
        return dao.login(user);
    }

    public boolean addUser(User user) {
        return dao.addUser(user);
    }

}
