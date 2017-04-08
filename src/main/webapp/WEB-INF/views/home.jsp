<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>My Spring app</title>
    <style>
        body {
            margin: 0;
        }

        header, footer {
            padding: 1em;
            color: white;
            background-color: black;
            clear: left;
            text-align: center;
        }
    </style>
</head>
<body>

    <myTag:horizontalMenu />

    <myTag:verticalMenu />

    <div style="margin-left:20%;margin-top:40px;padding:1px 16px;height:auto;">
        <myTag:books />
    </div>

    <footer>
        <h1> Copyright Gabriel Moskal</h1>
    </footer>
</body>
</html>
