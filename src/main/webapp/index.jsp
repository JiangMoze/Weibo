<%@ page import="com.moze.vo.Weibo" %>
<%@ page import="com.moze.dao.WeiboDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.moze.dao.UserDao" %>
<%@ page import="com.moze.vo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 蒋东雨
  Date: 2016/11/3
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>微博</title>
  </head>
  <body>
  <form action="Login" method="get" >
    <div align="right">

    <%
        if(request.getSession().getAttribute("login")!=null){
            %>
        <span><%=request.getSession().getAttribute("login")%></span>
        <a href="LoginOutControl">注销</a>
            <%
                }
        if(request.getSession().getAttribute("user")==null){
            %>
            <span>请先登录：</span> <input type="text" id="username" name="username" placeholder="用户名">
            <input type="password" id="password" name="password" placeholder="密码">
            <input type="submit" value="登录"/>
            <a href="register.jsp" >注册</a>

            <%
        }
    %>

    </div>
      <div align="center" >
        <a href="newweibo.jsp" >发微博</a>

      </div>
      <div align="center">
          <table border="1"  >
              <%
                  List<Weibo> list=new WeiboDao().queryMessage();
                  for(Weibo weibo:list){
              %>
              <tr>
                  <td width="100"><%=weibo.getUsername()%></td>
                  <td width="400"><%=weibo.getContent() %></td>
                  <td width="170"><%=weibo.getDatetime()%></td>
                  <td>
                  <%
                      String username=(String) request.getSession().getAttribute("username");
                      if(username!=null){


                      String username1=weibo.getUsername();
                      if(username.equals(username1)){
                          int id=weibo.getId();
                  %>

                      <a href="delControl?id=<%=id%>">删除</a>
                   <%
                           }
                      }
                   %>

                  </td>
              <%
                  }
              %>
              </tr>


          </table>

      </div>



  </form>

  </body>
</html>
