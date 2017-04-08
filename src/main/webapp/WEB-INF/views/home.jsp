<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false" %>
<html>
<head>
    <title>My Spring app</title>
    <style>
        body {
            margin: 0;
        }

        ul.horizontal_bar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: blue;
            position: fixed;
            top: 0;
            width: 100%;
            height: 40px;
        }

        ul.horizontal_bar li {
            display: inline;
            float: right;
        }

        ul.horizontal_bar li a {
            display: block;
            padding: 8px;
            color: white;
            text-decoration: none;
        }

        ul.horizontal_bar li a:hover {
            background-color: red;
            height: 40px;
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
            background-color: #4CAF50; /* Green */
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

    <div>
    <ul class="horizontal_bar">
        <li><a href="#home">Home</a></li>
        <li><a href="#user_panel">User Panel</a></li>
        <li><a href="#login">Log in</a></li>
        <li><a href="#logout">Log out</a></li>
    </ul>
    </div>

    <div>
    <ul class="vertical_bar">
        <h1>Kategorie</h1>
        <c:forEach var="category" items="${categories}" >
            <sf:form method="GET" modelAttribute="categories" action="category" acceptCharset="UTF-8">
                <input type="hidden" name="categoryUrl" value="<c:out value="${category.key}"/>" />
                <input type="hidden" name="categoryName" value="<c:out value="${category.value}"/>" />
                <button type="submit" class="btn_link"><c:out value="${category.value}" /></button>
            </sf:form>
        </c:forEach>
    </ul>
    </div>

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
