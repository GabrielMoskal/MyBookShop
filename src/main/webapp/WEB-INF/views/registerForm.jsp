<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="registration.title" /></title>
</head>
<body>
    <h2><s:message code="registration.title" /></h2>
    <sf:form method="POST" modelAttribute="user" acceptCharset="UTF-8">
        <table>
            <tr>
                <td><s:message code="registration.username" /></td>
                <td><sf:input path="username" /></td>
                <td><sf:errors path="username" /></td>
            </tr>
            <tr>
                <td><s:message code="registration.password" /></td>
                <td><sf:password path="password" /></td>
                <td><sf:errors path="password" /><sf:errors cssClass="user" /></td>
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
                <td><s:message code="registration.email" /></td>
                <td><sf:input path="email" /></td>
                <td><sf:errors path="email" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="<s:message code="registration.register" />" /></td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
