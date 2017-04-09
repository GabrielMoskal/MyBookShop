<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Spring App</title>
</head>
<body>
<myTag:horizontalMenu />
<div style="margin-left:10%;margin-top:40px;padding:1px 16px;height:1000px;">
    <ul>
        <h1><c:out value="${book.title}" /></h1>
    </ul>
    <ul>
        <img src="<c:out value="${book.imgUrl}" /> ">
    </ul>
    <ul>
        <h2><s:message code="book.details" /> </h2>
    </ul>
    <ul>
        <h3>
            <s:message code="book.author" />
            <c:out value="${book.author}"/>
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.language" />
            <c:out value="${book.language}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.index" />
            <c:out value="${book.index}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.translator" />
            <c:out value="${book.translator}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.copying" />
            <c:out value="${book.copying}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.devices" />
            <c:out value="${book.devices}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.format" />
            <c:out value="${book.format}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.pages" />
            <c:out value="${book.pages}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.printing" />
            <c:out value="${book.printing}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.publisher" />
            <c:out value="${book.publisher}" />
        </h3>
    </ul>
    <ul>
        <h3>
            <s:message code="book.year" />
            <c:out value="${book.year}" />
        </h3>
    </ul>
    <ul>
        <h2>
            <s:message code="book.description"/>
        </h2>
    </ul>
    <ul>
        <h3>
            <c:out value="${book.description}" />
        </h3>
    </ul>
</div>
</body>
</html>
