<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<style>
    ul.vertical_bar {
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 20%;
        background-color: #4CAF50;
        position: fixed;
        height: 100%;
        overflow: auto;
        font-family: Arial, Helvetica, sans-serif;
    }

    ul.vertical_bar li a {
        display: block;
        color: white;
        padding: 16px 32px;
        text-decoration: none;
        text-align: center;
    }

    ul.vertical_bar li a:hover {
        background-color: #555;
        color: white;
    }

    ul.vertical_bar h1 {
        size: 16px;
        color: white;
        background-color: #4CAF50;
        padding: 5px;
        margin: 0;
    }

</style>

<div>
    <ul class="vertical_bar">
        <h1><s:message code="userProfile.title" /></h1>
        <li>
            <a href="<c:url value="/cart" />" >
                <s:message code="userProfile.shoppingCart" />
            </a>
        </li>
    </ul>
</div>