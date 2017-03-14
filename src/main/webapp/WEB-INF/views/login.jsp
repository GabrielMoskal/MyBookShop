<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title><s:message code="myapp.login" /> </title>
</head>
<body>

<form method="POST" action="login">
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
            <td><input type="submit" value="<s:message code="myapp.login" />" /></td>
        </tr>
    </table>
</form>

</body>
</html>
