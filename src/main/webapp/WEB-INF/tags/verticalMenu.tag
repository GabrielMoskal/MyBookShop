<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<style>
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
        font-family: Arial, Helvetica, sans-serif;
    }

    ul.vertical_bar h1 {
        size: 16px;
        color: white;
        background-color: #4CAF50;
        padding: 5px;
        margin: 0;
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

<div>
    <ul class="vertical_bar">
        <h1><s:message code="verticalMenu.categories" /></h1>
        <c:forEach var="category" items="${categories}" >
            <form method="GET" action="<c:url value="/category"/>" >
                <input type="hidden" name="categoryUrl" value="<c:out value="${category.key}"/>" />
                <input type="hidden" name="categoryName" value="<c:out value="${category.value}"/>" />
                <button type="submit" class="btn_link"><c:out value="${category.value}" /></button>
            </form>
        </c:forEach>
    </ul>
</div>