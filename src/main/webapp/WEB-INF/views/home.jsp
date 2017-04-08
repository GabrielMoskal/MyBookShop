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

    <div style="margin-left:20%;margin-top:40px;padding:1px 16px;height:1000px;">
        <a href="category/komiks">Go TO KOMIKS</a>
        <h2>Fixed Full-height Side Nav</h2>
        <h3>Try to scroll this area, and see how the sidenav sticks to the page</h3>
        <p>Notice that this div element has a left margin of 25%. This is because the side navigation is set to 25% width. If you remove the margin, the sidenav will overlay/sit on top of this div.</p>
        <p>Also notice that we have set overflow:auto to sidenav. This will add a scrollbar when the sidenav is too long (for example if it has over 50 links inside of it).</p>
        <p>Some text..</p>
        <p>Some text..</p>
        <p>Some text..</p>
        <p>Some text..</p>
        <p>Some text..</p>
        <p>Some text..</p>
        <p>Some text..</p>
    </div>

    <footer>
        <h1> Copyright Gabriel Moskal</h1>
    </footer>
</body>
</html>
