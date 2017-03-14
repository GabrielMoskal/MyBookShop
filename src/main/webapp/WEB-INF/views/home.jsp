<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<head>
    <title>My Spring App</title>
</head>
<body>
    <h1><s:message code="myapp.welcome" /></h1>
    <s:url value="/users/register" var="registerUrl" />
    <a href="${registerUrl}"> <s:message code="registration.register" /></a> |
    <s:url value="/users/login" var="loginUrl" />
    <a href="${loginUrl}" ><s:message code="myapp.login" /></a>
    <br><br>
    <s:message code="test.myTest" />
</body>
</html>
