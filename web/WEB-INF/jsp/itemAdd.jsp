<%-- 
    Document   : itemAdd
    Created on : 14 mars 2018, 15:28:26
    Author     : Utilisateur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Auction Page</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    </head>
    <body>
        <h1>Adding new Auction</h1>
        <form:form action="itemCreate.do" method="POST">
            <table>
                <tr>
                    <th>Auction Type</th>
                    <th>Seller</th>
                    <th>Description</th>
                    <th>Category</th>
                </tr>
                <tr>
                    <td><input type="text" size="20" name="title" value=""></td>
                    <td><input type="text" size="20" name="author" value=""></td>
                    <td><input type="text" size="100" name="body" value=""></td>
                    <td>
                        <select name="categoryId.id">
                            <option value="-1"></option>
                            <c:forEach var="category" items="${listCategory}">
                                <option value="${category['id']}">${category['name']}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><button type="submit">Insert Auction</button> </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
