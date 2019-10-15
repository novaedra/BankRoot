<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>BankRoot - Connexion</title>
</head>
<body>
<form action="LoginController" method="post">
    <label for="mail">Mail&nbsp;:</label>
    <input type="text" name="mail" id="mail">
    <label for="mdp">Mot de passe&nbsp;:</label>
    <input type="password" name="mdp" id="mdp">
    <input type="submit" value="Se connecter">
</form>
</body>
</html>
