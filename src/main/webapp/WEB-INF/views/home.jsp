<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>My Spring App</title>
</head>
<body>
    <c:forEach var="category" items="${categories}">
        <form action="/home" method="GET" >
            <table>
                <tr>
                    <td><input type="submit" value="<c:out value="${category}" />"/></td>
                </tr>
            </table>
        </form>
    </c:forEach>


    <h1><s:message code="myapp.welcome" /></h1>
    <security:authorize access="isAuthenticated()">
        <s:message code="myapp.greeting" /> <security:authentication property="principal.username" />!
    </security:authorize>
    <br>
    <s:url value="/users/register" var="registerUrl" />
    <a href="${registerUrl}"> <s:message code="registration.register" /></a> |
    <s:url value="/users/login" var="loginUrl" />
    <a href="${loginUrl}" ><s:message code="myapp.login" /></a> |
    <s:url value="/logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="POST" id="logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" name="logout" value="<s:message code="myapp.logout" />" >
    </form>
    <br><br>
    <s:message code="test.myTest" />

    <form method="POST" accept-charset="UTF-8">
        <input type="text" name="username" value="" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" value="TEST" name="test">
    </form>
</body>
</html>
