package com.moze.control;

import com.moze.service.UserService;
import com.moze.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/7.
 */
@WebServlet(name = "LoginControl",urlPatterns = {"/Login"})
public class LoginControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String pwd=request.getParameter("password");
        User user=new User(username,pwd);

        UserService service=new UserService();
        User user1= service.login(user);
        if(  (user1!=null)){


            request.getSession().setAttribute("user",user1);
            //cookie

            Cookie c=new Cookie("http://www.moze.com",username);
            c.setMaxAge(3600*24*7);
            response.addCookie(c);

            Cookie c1=new Cookie("http://www.moze.com",pwd);
            c1.setMaxAge(3600*24*7);
            response.addCookie(c1);


            request.getSession().setAttribute("login", "欢迎你"+user1.getUsername());
            request.getSession().setAttribute("username",user1.getUsername());
            RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");

            dispatcher.forward(request,response);

        }else{
            request.getSession().setAttribute("login", "登录失败!");
            RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");

            dispatcher.forward(request,response);

        }




    }








}
