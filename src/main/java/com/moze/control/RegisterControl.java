package com.moze.control;

import com.moze.service.UserService;
import com.moze.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/8.
 */
@WebServlet(name = "RegisterControl",urlPatterns = {"/Register"})
public class RegisterControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String pwd=request.getParameter("password");
        User user=new User(username,pwd);

        UserService service=new UserService();
        service.addUser(user);

        RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);


    }
}
