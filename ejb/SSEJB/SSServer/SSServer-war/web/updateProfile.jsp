<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Profile</title>
    </head>
    <body bgcolor="#E6E6FA" style="color: white;background-image: url(http://localhost:8080/SSServer-war/css/login-background.jpg)">
        <h1 style="text-align: center;">Smart Holdings System</h1> <hr> <br>
        <table bgcolor="#F3E8FA" align="center" width="900" border="1">
            <tr>
                <th width="100" scope="col"><a href="updateProfile">Change Password</a></th>
                <th width="130" scope="col"><a href="logout">Logout</a></th>
            </tr>
        </table>
        <br/><br/><br/>
        <form action="updateResult" method="POST">
            <%
                String name = (String) session.getAttribute("name");
                String staffID = (String) session.getAttribute("staffID");
                String email = (String) session.getAttribute("email");
            %>
           <table align="center" width = "360">
                <tr align = "left">
                    <td>Name:</td>
                    <td style="text-align: left;"><%=name%></td>
                </tr>
                <tr align = "left">
                    <td>Staff ID:</td>
                    <td style="text-align: left;"><%=staffID%></td>
                </tr>
                <tr align = "left">
                    <td>Email:</td>
                    <td style="text-align: left;"><%=email%></td>
                </tr>
                <tr align = "left">
                    <td>Enter old Password:</td>
                    <td style="text-align: center;"><span style="color: #999999;"><input type="password" name="oldPassword" placeholder="Current Password" /></span></td>
                </tr>
                <tr align = "left">
                    <td>Enter new Password:</td>
                    <td style="text-align: center;"><span style="color: #999999;"><input type="password" name="newPassword" placeholder="New Password" /></span></td>
                </tr>
                <tr align = "left">
                    <td>Enter new Password Again:</td>
                    <td style="text-align: center;"><span style="color: #999999;"><input type="password" name="new2Password" placeholder="New Password" /></span></td>
                </tr>
            </table>
            <br/>
            <%
                int result = 0;
                try {
                    result = (Integer) request.getAttribute("result");
                } catch (NullPointerException ex) {
                    result = 0;
                }
                if (result == -1) { %>
            <p style="text-align: center; color:red"> <b>Current Password Incorrect!</b></p>
            <%} else if (result == -2) { %>
            <p style="text-align: center; color:red"> <b>New Password Inconsistent! </b></p>
            <%} else if (result == 1) { %>
            <p style="text-align: center; color:green"> <b>Profile has been updated! </b></p>
            <%}%>

            <br/> <br/>
            <p style="text-align: center;"><span style="color: #999999;"><input type="submit" value="Save Change"/> </span></p>
        </form>
    </body>
</html>

