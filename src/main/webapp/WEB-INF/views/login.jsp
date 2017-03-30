<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title><s:message code="myapp.login" /> </title>
</head>
<body>

<form method="POST" action="login" accept-charset="UTF-8">
    <h2><s:message code="logging.title" /></h2>
    <table>
        <tr>
            <td><s:message code="registration.username" /></td>
            <td><input type="text" name="username" value="" /></td>
        </tr>
        <tr>
            <td><s:message code="registration.password" /></td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td><input id="remember_me" name="remember-me" type="checkbox" /></td>
            <td><s:message code="logging.rememberMe" /></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <tr>
            <td><input type="submit" value="<s:message code="myapp.login" />" /></td>
        </tr>
    </table>
</form>
<form action="test" method="POST" accept-charset="UTF-8">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="TEST" name="test">
</form>

</body>
</html>
