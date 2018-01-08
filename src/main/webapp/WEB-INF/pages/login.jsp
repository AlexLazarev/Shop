<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.css" />" rel="stylesheet">

</head>

<body>

<div class="container">

    <form method="POST" action="/login" class="form-signin">
        <h2 class="form-signin-heading">Login</h2>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <div>${error}</div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="sg-btn" type="submit">Log In</button>
            <a class="sg-register__link" href="register">Create an account</a>
        </div>
    </form>

</div>
</body>
</html>