
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
    <form method="POST">
        <h2>Rejestracja</h2>
        <h3>Login: </h3>
        <input type="text" name="username"> <br>
        <h3>Hasło: </h3>
        <input type="password" name="password"> <br>
        <h3>Powtórz hasło: </h3>
        <input type="password" name="confirmedPassword"> <br>
        <h3>Imię: </h3>
        <input type="text" name="firstName" /> <br>
        <h3>Nazwisko: </h3>
        <input type="text" name="lastName" /> <br><br>

        <input type="submit" value="Zarejestruj">
    </form>
</body>
</html>
