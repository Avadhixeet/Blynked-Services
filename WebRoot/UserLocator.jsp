<%-- 
    Document   : UserLocator
    Created on : 20 Jul, 2015, 5:56:21 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Location</title>
    </head>
    <body>
        <%
        out.println(request.getAttribute("mapdata"));
        %>
    </body>
</html>
