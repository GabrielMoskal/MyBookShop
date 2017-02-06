<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>

<html>
<head>
    <title>My Spring App</title>
</head>
<body>
    <h1><s:message code="myapp.welcome" /></h1>
    <a href="<c:url value="/users/register" />"> Zarejestruj</a> |
    <a href="<c:url value="/users/login" />"> Zaloguj</a>
</body>
</html>
