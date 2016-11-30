package com.moze.control;

import com.moze.service.WeiboService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/10.
 */
@WebServlet(name = "DelWeiboControl",urlPatterns = {"/delControl"})
public class DelWeiboControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        WeiboService service=new WeiboService();
        service.delWeibo(id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request,response);
    }
}
