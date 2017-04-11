<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>My Spring App</title>
</head>
<body>
    <myTags:horizontalMenu />
    <myTags:cartMenu />

    <c:out value="${cart.bookidToQuantity}" />

</body>
</html>
