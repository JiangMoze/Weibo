package com.moze.control;

import com.moze.service.WeiboService;
import com.moze.vo.User;
import com.moze.vo.Weibo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/10.
 */
@WebServlet(name = "NWeiboControl",urlPatterns = {"/NWeibo"})
public class NWeiboControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"utf-8");
        User user=(User) request.getSession().getAttribute("user");
        int uid=user.getId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String date=df.format(new Date());

        Weibo weibo=new Weibo();
        weibo.setContent(content);
        weibo.setUid(uid);
        weibo.setDatetime(date);
        WeiboService service=new WeiboService();
        service.addWeibo(weibo);
        request.setAttribute("username", user.getUsername());
        RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
