package com.moze.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/11/11.
 */
@WebServlet(name = "LoginOutControl",urlPatterns = {"/LoginOutControl"})
public class LoginOutControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("login");
        RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request,response);

    }
}
