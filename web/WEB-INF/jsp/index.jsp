<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AuctionMan Connection page</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/login.css">
    </head>

    <body>
        <form:form action="items.do" method="POST">
            <h1>Auctions login</h1>
            <p><input type="text" name="login" /></p>
            <p><input type="password" name="passw" /></p>
            <p><button type="submit">Login</button></p>
        </form:form>
    </body>
</html>
