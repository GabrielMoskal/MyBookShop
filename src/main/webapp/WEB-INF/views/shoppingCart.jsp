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
            <c:forEach items="${cart.shoppingCartItems}" var="book">
                <tr>
                    <td>
                        <a href="<c:url value="/book/${book.bookid}" />">
                            <c:out value="${book.bookTitle}"/>
                        </a>
                    </td>
                    <td><c:out value="${book.quantity}" /></td>
                    <td>
                        <form method="POST">
                            <input type="hidden" name="bookid" value="<c:out value="${book.bookid}" />">
                            <input type="hidden" name="quantity" value="1">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
                            <button class="btn_link" type="submit" value="update_cart" >
                                <s:message code="shoppingCart.add"/>
                            </button>
                        </form>
                    </td>
                    <td><s:message code="shoppingCart.remove"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
