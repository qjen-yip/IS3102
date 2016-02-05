<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Update Result</title>
    </head>
    <%
        int result = (Integer) request.getAttribute("result");
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateProfile");
        dispatcher.forward(request, response);
    %>
</html>
