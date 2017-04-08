<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${books}" var="book">
    <c:out value="${book.author}" /> <br>
</c:forEach>

</body>
</html>
