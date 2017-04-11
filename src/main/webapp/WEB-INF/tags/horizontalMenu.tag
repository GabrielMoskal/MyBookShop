<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<style>
    ul.horizontal_bar {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: blue;
        position: fixed;
        top: 0;
        width: 100%;
        height: 40px;
    }

    ul.horizontal_bar li {
        display: inline;
        float: right;
    }

    ul.horizontal_bar li a {
        display: block;
        align-content: center;
        padding: 8px;
        color: white;
        font-size: 16px;
        text-decoration: none;
        font-family: Arial, Helvetica, sans-serif;
        text-align: center;
        outline:none;
        height: 40px;
    }

    ul.horizontal_bar li a:hover {
        background-color: red;
        height: 40px;
    }

    input[type=submit] {
        display: inline-block;
        padding: 8px;
        color: white;
        text-decoration: none;
        font-family: Arial, Helvetica, sans-serif;
        height: 40px;
        background-color: blue;
        border: none;
        text-align: center;
        font-size: 16px;
        cursor: pointer;
        outline:none;
        width: 100%;
    }
</style>

<div>
    <ul class="horizontal_bar">
        <security:authorize access="!isAuthenticated()">
            <li><a href="<c:url value="/users/register" /> "><s:message code="registration.register"/> </a></li>
        </security:authorize>

        <security:authorize access="!isAuthenticated()">
            <li><a href="<c:url value="/users/login" /> "><s:message code="myapp.login"/> </a></li>
        </security:authorize>

        <security:authorize access="isAuthenticated()">
            <li>
                <a href="<c:url value="/users/profile" />" >
                    <s:message code="userProfile.profile" />
                </a>
            </li>
        </security:authorize>

        <security:authorize access="isAuthenticated()">
            <li>
            <s:url value="/logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="POST" id="logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" name="logout" value="<s:message code="myapp.logout" />" >
            </form>
            </li>
        </security:authorize>

        <li><a href="<c:url value="/" /> "><s:message code="myapp.home"/> </a></li>
    </ul>
</div>