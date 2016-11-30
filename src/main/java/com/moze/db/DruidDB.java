package com.moze.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/11.
 */
public class DruidDB {
    private static Connection conn;//声明连接
    private static DataSource ds;//声明数据源
    static {
        Properties pro=new Properties(); //声明特性（驱动）
        try {
            pro.load(DruidDB.class.getClassLoader().getResourceAsStream("druid.ini"));//驱动加载的配置

            ds= DruidDataSourceFactory.createDataSource(pro);//驱动创建数据源
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){

        try {
            conn=ds.getConnection();//通过数据源创建连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        System.out.print(getConnection());
    }
}
