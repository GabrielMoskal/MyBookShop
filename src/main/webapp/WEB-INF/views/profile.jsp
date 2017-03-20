<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title><c:out value="${user.username}"/></title>
</head>
<body>
    <c:out value="${user.username}" /> <br/>
    <c:out value="${user.firstName}" />
    <c:out value="${user.lastName}" />
</body>
</html>
