<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<style>
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
</style>

<div>
    <ul class="horizontal_bar">
        <li><a href="#home">Home</a></li>
        <li><a href="#user_panel">User Panel</a></li>
        <li><a href="#login">Log in</a></li>
        <li><a href="#logout">Log out</a></li>
    </ul>
</div>