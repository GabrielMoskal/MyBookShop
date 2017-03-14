<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title><s:message code="registration.title" /></title>
</head>
<body>
    <h2><s:message code="registration.title" /></h2>
    <sf:form method="POST" commandName="user" >
        <table>
            <tr>
                <td><s:message code="registration.username" /></td>
                <td><sf:input path="username" /></td>
                <td><sf:errors path="username" /></td>
            </tr>
            <tr>
                <td><s:message code="registration.password" /></td>
                <td><sf:password path="password" /></td>
                <td><sf:errors path="password" /></td>
            </tr>
            <tr>
                <td><s:message code="registration.confirmedPassword" /></td>
                <td><sf:password path="confirmedPassword" /></td>
            </tr>
            <tr>
                <td><s:message code="registration.firstName" /></td>
                <td><sf:input path="firstName" /></td>
                <td><sf:errors path="firstName" /></td>
            </tr>
            <tr>
                <td><s:message code="registration.lastName" /></td>
                <td><sf:input path="lastName" /></td>
                <td><sf:errors path="lastName" /> <br/></td>
            </tr>
            <tr>
                <td><input type="submit" value="<s:message code="registration.register" />" /></td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
