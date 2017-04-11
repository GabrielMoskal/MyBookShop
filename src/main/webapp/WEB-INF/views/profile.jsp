<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>My Spring App</title>
    <style>

        body {
            margin: 0;
        }

        ul.vertical_bar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 20%;
            background-color: #f1f1f1;
            top: 40px;
            position: fixed;
            height: 100%;
            overflow: auto;
        }

        ul.vertical_bar li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
            text-align: center;
        }

        ul.vertical_bar li a.active {
            background-color: #4CAF50;
            color: white;
        }

        ul.vertical_bar li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }

        ul.vertical_bar li a:active:not(.active) {
            background-color: red;
            color: white;
        }

        ul.vertical_bar h1 {
            size: 16px;
            color: black;
            padding: 5px;
            margin: 5px;
        }

        .btn_link {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            float: left;
            outline:none;
            width: 100%;
            font-family:inherit;
        }

        .btn_link:hover:not(.active) {
            background-color: #555;
            color: white;
            border: none;
            outline: none;
        }
    </style>
</head>
<body>
<myTags:horizontalMenu />
<div>
    <ul class="vertical_bar">
        <h1><s:message code="userProfile.title" /></h1>
        <a href="<s:url value="/cart"/>"><s:message code="userProfile.shoppingCart" /></a>
    </ul>
</div>

</body>
</html>
