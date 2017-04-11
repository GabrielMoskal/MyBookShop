<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>My Spring App</title>
</head>
<body>
    <myTags:horizontalMenu />
    <myTags:cartMenu />

    <div style="margin-left:20%;margin-top:40px;padding:1px 16px;height:auto;" >
        <c:forEach items="${cart.shoppingCartItems}" var="items">
            <c:out value="${items.bookTitle}" />
            <c:out value="${items.quantity}" />
        </c:forEach>
    </div>

</body>
</html>
