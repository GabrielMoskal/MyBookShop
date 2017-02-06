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

        <s:message code="registration.username" />
        <sf:input path="username" />
        <sf:errors path="username" /> <br/>

        <s:message code="registration.password" />
        <sf:password path="password" />
        <sf:errors path="password" /> <br/>

        <s:message code="registration.confirmedPassword" />
        <sf:password path="confirmedPassword" /> <br/>

        <s:message code="registration.firstName" />
        <sf:input path="firstName" />
        <sf:errors path="firstName" /> <br/>

        <s:message code="registration.lastName" />
        <sf:input path="lastName" />
        <sf:errors path="lastName" /> <br/>

        <input type="submit" value="<s:message code="registration.register" />" />
    </sf:form>
</body>
</html>
