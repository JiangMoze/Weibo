package com.moze.dao;

import com.moze.db.DB;
import com.moze.db.DruidDB;
import com.moze.vo.Weibo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/7.
 */
public class WeiboDao {
    Connection conn=null;
    public WeiboDao() {

        conn= DruidDB.getConnection();

    }


    public static void main(String[] args) {
        List<Weibo> list=new WeiboDao().queryMessage();
        for(Weibo weibo:list){
            System.out.print(weibo.getContent()+" ");
            System.out.print(weibo.getDatetime()+"<br>");

        }
    }
    public List<Weibo> queryMessage() {

        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select distinct article.id,article.content,article.date,user.username from user,article where article.uid=user.id";
        List<Weibo> list=new ArrayList<Weibo>();
        try{
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while(rs.next()){
                Weibo wb=new Weibo();
                wb.setId(rs.getInt("id"));
                wb.setContent(rs.getString("content"));
                wb.setDatetime(rs.getString("date"));
                wb.setUsername(rs.getString("username"));
                list.add(wb);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }


        return list;
    }
    public boolean delWeibo(int id) {
        PreparedStatement pstmt=null;
        boolean flag=false;
        try {
            String sql="delete from article where id=? ";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            flag=pstmt.executeUpdate()>0?true:false;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }
    /***
     *
     * 添加微博
     * @param weibo 传递一个微博对象
     * @return  若添加成功则返回真
     */
    public boolean addWeibo(Weibo weibo) {


        PreparedStatement pstmt=null;

        boolean flag=false;
        try {
            pstmt=conn.prepareStatement("insert into article (content,date,uid) values(?,?,?); ");


            pstmt.setString(1,weibo.getContent());
            pstmt.setString(2,weibo.getDatetime());
            pstmt.setInt(3,weibo.getUid());


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
