<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
        }

        .page-navigation-box li {
            display: inline-block;
            margin: 5px;
            border: 3px red;
        }

        .navigation-button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 5px 5px;
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

    </style>
</head>
<body>

<myTag:horizontalMenu />

<myTag:verticalMenu />

<div style="margin-left:20%;margin-top:40px;padding:1px 16px;height:1000px;">
    <myTag:books />

    <br><br>
    <ul class="page-navigation-box" >
        <c:forEach var="navigationButton" items="${navigationButtons}" >
        <li>
        <form method="GET" action="<c:out value="${categoryUrl}" />" >
            <input type="hidden" name="booksLimit" value="25">
            <input type="hidden" name="pageNumber" value="<c:out value="${navigationButton.pageNumber}" />" >
            <input type="hidden" name="categoryName" value="<c:out value="${categoryName}" />" >
            <input type="hidden" name="categoryUrl" value="<c:out value="${categoryUrl}"/>" >
            <button type="submit" class="navigation-button"><c:out value="${navigationButton.name}" /></button>
        </form>
        </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
