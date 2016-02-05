<%-- 
    Document   : login
    Created on : Feb 1, 2016, 6:57:57 PM
    Author     : yingweiliu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>S-Mart Holdings System</title>
    </head>
    <body  bgcolor="#E6E6FA" style="color: white;background-image: url(http://localhost:8080/SSServer-war/css/login-background.jpg)">
        <br> <br> 
        <h1 style="text-align: center; ">Smart Holdings System</h1>
        <hr> <br>
        <form action="loginResult" method="POST" stlye="height:300px;width:300px;margin:0 auto;">
       <%
                int result = 0;
                try {
                    result = (Integer) request.getAttribute("result");
                } catch (NullPointerException ex) {
                    result = 0;
                }
                if (result == -1) { %>
            
            <p style="text-align: center; color:red"> <b>Invalid Staff ID! Please try again.</b></p>
            <%} else if (result == -2) { %>
            <p style="text-align: center; color:red"> <b>Wrong Password! Please try again.</b></p>
            <%}%>
            <p style="text-align: center;"><input style="height: 30px; width:200px;" type="text" name="staffID" placeholder="Staff ID"/></p>
            <p style="text-align: center;"><input style="height: 30px; width:200px" type="password" name="password" placeholder="Password" /></p>
            <p style="text-align: center;"><input style="height: 50px; width:200px" type="submit" value="Login"/></p>
        </form>
        <p style="text-align: center;">
        </p>
    </body>
</html>