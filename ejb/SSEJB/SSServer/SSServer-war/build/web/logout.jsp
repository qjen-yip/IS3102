<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%
        session.invalidate();
    %>
    <script type="text/javascript">
        alert("You have Logout Successfully!");
        window.location = "login";
    </script> 
</html>
