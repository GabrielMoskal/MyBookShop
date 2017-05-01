<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title><s:message code="registration.title" /></title>
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

    <h2><s:message code="registration.title" /></h2>
    <sf:form method="POST" modelAttribute="userRegistration" acceptCharset="UTF-8">
        <table>
            <tr>
                <td><s:message code="registration.username" /></td>
                <td><sf:input path="username" /></td>
                <td><sf:errors path="username" /></td>
            </tr>
            <tr>
                <td><s:message code="registration.password" /></td>
                <td><sf:password path="password.password" /></td>
                <td><sf:errors path="password.password" />
                    <sf:errors cssClass="user" /></td>
            </tr>
            <tr>
                <td><s:message code="registration.confirmedPassword" /></td>
                <td><sf:password path="password.confirmedPassword" /></td>
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
