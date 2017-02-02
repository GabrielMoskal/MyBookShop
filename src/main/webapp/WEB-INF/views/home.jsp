<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Strona główna</title>
</head>
<body>
    <h1>Witam na stronie głównej</h1>
    <a href="<c:url value="/register" />"> Zarejestruj</a> |
    <a href="<c:url value="/login" />"> Zaloguj</a>
</body>
</html>
