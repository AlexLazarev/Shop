<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width-device-width, initial-scale=1.0">
    <title>test</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.css" />" rel="stylesheet">
</head>
<body>

    <div id="wrapper">
            <div class="container">
                <div class="register">
                    <div class="register-title text-center">
                        <h4 class="bold-title">Регистрация</h4>
                    </div>
                    <div class="register-body">
                        <div class="register-body__info">
                            <p class="register-body__boldtext">Связь с социальными сетями</p>
                            <p class="register-body__text big-padding">Вы можете зарегистрироваться на сайте с помощью учетных записей социальных сетей</p>
                            <i class="register-body__link fa fa-facebook fa-lg" aria-hidden="true"></i>
                            <i class="register-body__link fa fa-google fa-lg" aria-hidden="true"></i>
                        </div>
                        <div class="register-body__form">

                            <form:form method="POST" modelAttribute="user" class="form-signin">
                                <h2 class="form-signin-heading">Create your account</h2>

                                <spring:bind path="firstName">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="firstName" class="form-control" placeholder="Name"
                                                    autofocus="true"></form:input>
                                        <form:errors path="firstName"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="lastName">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="lastName" class="form-control" placeholder="Surname"></form:input>
                                        <form:errors path="lastName"></form:errors>
                                    </div>
                                </spring:bind>


                                <spring:bind path="number">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="number" class="form-control" placeholder="Number"></form:input>
                                        <form:errors path="number"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="email">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="email" class="form-control" placeholder="Email"></form:input>
                                        <form:errors path="email"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="username">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="username" class="form-control" placeholder="Username"></form:input>
                                        <form:errors path="username"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="password">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                                        <form:errors path="password"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="confirmPassword">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="password" path="confirmPassword" class="form-control"
                                                    placeholder="Confirm your password"></form:input>
                                        <form:errors path="confirmPassword"></form:errors>
                                    </div>
                                </spring:bind>

                                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
    </div>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>

</body>
</html>