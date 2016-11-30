package com.moze.dao;

import com.moze.control.LoginControl;
import com.moze.db.DB;
import com.moze.db.DruidDB;
import com.moze.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/6.
 */
public class UserDao {
    Connection conn=null;
    public UserDao() {

        conn= DruidDB.getConnection();

    }


    /***
     *
     * @param user 携带用户名和密码的user
     * @return 验证成功则返回一个user
     */

    public User login(User user){
        User user1=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {

            pstmt=conn.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            rs=pstmt.executeQuery();
            if(rs.next()){
                user1=new User(rs.getString("username"),rs.getString("password"));
                user1.setId(rs.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user1;
        }


    }

    /***
     *
     * @param user 传递一个包含用户信息的user
     * @return  若成功添加用户返回TRUE
     */

    public boolean addUser(User user) {


        PreparedStatement pstmt=null;

        boolean flag=false;
        try {
            pstmt=conn.prepareStatement("insert into user (username,password) values(?,?); ");


            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());


            flag=pstmt.executeUpdate()>0?true:false;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{


            try {
                if(pstmt!=null){
                    pstmt.close();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return flag;

        }
    }
}
