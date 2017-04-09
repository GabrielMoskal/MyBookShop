<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<style>
    .floating-box {
        display: inline-block;
        width: 140px;
        height: 300px;
        margin: 20px;
    }

    .floating-box p {
        display: table;
    }
</style>

<h1><c:out value="${categoryName}" /></h1>

<c:forEach var="book" items="${books}" >
    <div class="floating-box" >
        <img src="<c:out value="${book.imgUrl}" />" style="width:140px;height:220px;" >
        <p><c:out value="${book.title}" /></p>
    </div>
</c:forEach>


