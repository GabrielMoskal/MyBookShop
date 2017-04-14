<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
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
        outline:none;
        width: 20%;
        font-family:inherit;
    }

    .btn_link:hover:not(.active) {
        background-color: #555;
        color: white;
        border: none;
        outline: none;
    }
</style>

<form method="POST" action="<c:url value="/cart" />" >
    <input type="hidden" name="bookid" value="<c:out value="${book.index}" />">
    <input type="hidden" name="quantity" value="1">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
    <button class="btn_link" type="submit" value="update_cart" ><s:message code="shoppingCart.add"/></button>
</form>