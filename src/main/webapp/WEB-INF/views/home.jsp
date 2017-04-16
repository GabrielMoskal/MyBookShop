<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>My Spring app</title>
    <style>
        body {
            margin: 0;
        }

        .page-navigation-box li {
            display: inline-block;
            margin: 5px;
            border: 3px red;
        }

        footer {
            padding: 1em;
            color: white;
            background-color: blue;
            clear: left;
            text-align: center;
            height: 40px;
        }
    </style>
</head>
<body>

    <myTag:horizontalMenu />

    <myTag:verticalMenu />

    <div style="margin-left:20%;margin-top:40px;padding:1px 16px;height:auto;">

        <h1><s:message code="myapp.new"/></h1>

        <myTag:books />

    </div>

    <footer>
        <h1> Copyright Gabriel Moskal</h1>
    </footer>
</body>
</html>
