<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.List" %>
<%@ page import="com.reneuby.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Reneuby
  Date: 2020-03-29
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <h2>Hello JSP</h2>
    <% response.getWriter().write("Hello from Ruslan");
        out.print("Test print");%>
    <br>
    <%=request.getRequestURI()%>
    <br>
    <%= LocalDateTime.now() %>
    <hr>
    <table>
    <%  List<User> users = (List) request.getAttribute("Users");
        if (users != null) {
            for (User user: users) {
    %>
                <tr><%out.print(user);%></tr>
                <br>
    <%
            }
        } else {
            out.print("There is no users in request");
        }
    %>
    </table>
</html>
