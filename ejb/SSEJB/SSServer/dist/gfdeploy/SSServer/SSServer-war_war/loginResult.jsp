<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Smart Holdings System</title>
    </head>
    <body bgcolor="#E6E6FA" style="color: white;background-image: url(http://localhost:8080/SSServer-war/css/login-background.jpg)">
     <h1 style="text-align: center;">Smart Holdings System</h1> <hr> <br>
        <% ArrayList data = new ArrayList();
            data = (ArrayList) request.getAttribute("data");
            int result = 0;

            if (data.get(0).equals("wrongID")) {
                result = -1;
                request.setAttribute("result", result);
                RequestDispatcher rd = request.getRequestDispatcher("login");
                rd.forward(request, response);
            } else if (data.get(0).equals("wrongPw")) {
                result = -2;
                request.setAttribute("result", result);
                RequestDispatcher rd = request.getRequestDispatcher("login");
                rd.forward(request, response);
            } else {
                result = 1;
                session.setAttribute("name", (String) data.get(2));
                session.setAttribute("staffID", (String) data.get(3));
                session.setAttribute("email", (String) data.get(4));
            }
        %>
        <table bgcolor="#F3E8FA" align="center" width="900" border="1">
            <tr>
                <th width="100" scope="col"><a href="updateProfile">Change Password</a></th>
                <th width="130" scope="col"><a href="logout">Logout</a></th>
            </tr>
        </table>
        <br/><br/><br/>
        <table align="center" width = "360">
                <tr align = "left">
                    <td>Name:</td>
                    <td style="text-align: left;"><%=(String) data.get(2)%></td>
                </tr>
                <tr align = "left">
                    <td>Staff ID:</td>
                    <td style="text-align: left;"><%=(String) data.get(3)%></td>
                </tr>
                <tr align = "left">
                    <td>Email:</td>
                    <td style="text-align: left;"><%=(String) data.get(4)%></td>
                </tr>
        </table>
    </body>
</html> 


