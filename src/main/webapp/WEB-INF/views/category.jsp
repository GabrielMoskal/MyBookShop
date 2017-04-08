<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
        }
    </style>
</head>
<body>

<myTag:horizontalMenu />

<myTag:verticalMenu />

<div style="margin-left:20%;margin-top:40px;padding:1px 16px;height:1000px;">
    <c:forEach items="${books}" var="book">
        <c:out value="${book.author}" /> <br>
    </c:forEach>
</div>

</body>
</html>
