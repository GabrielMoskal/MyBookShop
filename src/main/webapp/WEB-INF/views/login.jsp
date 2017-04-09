<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title><s:message code="myapp.login" /> </title>
    <style>
        body {
            margin: 0;
        }

        input {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            border: 2px solid green;
            border-radius: 5px;
        }
    </style>

</head>
<body>

<myTag:horizontalMenu />

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
            <td><s:message code="logging.rememberMe" /></td>
            <td><input id="remember_me" name="remember-me" type="checkbox" /></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <tr>
            <td><input type="submit" value="<s:message code="myapp.login" />" /></td>
        </tr>
    </table>
</form>

</body>
</html>
