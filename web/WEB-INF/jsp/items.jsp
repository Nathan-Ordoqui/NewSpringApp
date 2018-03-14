<%-- 
    Document   : listitems.jsp
    Created on : 7 mars 2018, 17:21:11
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items Page</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <h1 id="homeTitle">List of items</h1>
        <table>
            <tr>
                <th>Auction #</th>
                <th>Auction Type</th>
                <th>Seller</th>
                <th>Description</th>
                <th>Category</th>
            </tr>
            <c:forEach var="item" items="${itemsList}">
            <tr>
                <td><c:out value="${item['id']}"/></td>
                <td><c:out value="${item['title']}"/></td>
                <td><c:out value="${item['author']}"/></td>
                <td><c:out value="${item['body']}"/></td>
                <td><c:choose>
                        <c:when test="${empty item['categoryId']['name']}">
                            No category
                        </c:when>
                        <c:otherwise>
                            <c:out value="${item['categoryId']['name']}"/>
                        </c:otherwise>
                </c:choose></td>
                    
            </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <form:form method="POST" action="itemAdd.do">
                        <button type="submit" name="createItem">Insert Auction</button>
                    </form:form>
                </td>
            </tr>
        </table>
    </body>
</html>
