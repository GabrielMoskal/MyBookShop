<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>My Spring App</title>

    <style>
        body {
            margin: 0;
        }

        table {
            border-collapse: collapse;
            width: 75%;
        }

        th {
            width: 50px;
            background-color: #4CAF50;
            color: white;
        }

        th, td {
            padding: 10px;
        }

        table, tr, td {
            border: 1px solid black;
        }

        tr:hover {
            background-color: greenyellow;
        }

    </style>
</head>
<body>
    <myTags:horizontalMenu />
    <myTags:profileMenu />

    <div style="margin-left:20%;margin-top:40px;padding:1px 16px;height:auto;" >
        <table>
            <tr>
                <th><s:message code="shoppingCart.title"/></th>
                <th><s:message code="shoppingCart.quantity"/></th>
            </tr>
            <c:forEach items="${cart.shoppingCartItems}" var="items">
                <tr>
                    <td><c:out value="${items.bookTitle}" /></td>
                    <td><c:out value="${items.quantity}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
