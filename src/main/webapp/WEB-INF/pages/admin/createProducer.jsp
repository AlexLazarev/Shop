<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

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
        <jsp:include page="header.jsp"/>
            <div class="container">
                <div class="register">
                    <div class="register-title text-center">
                        <h4 class="bold-title">Добавление поставщика</h4>
                    </div>
                    <div class="register-body">
                        <div class="register-body__info">
                            <p class="register-body__boldtext">Описание</p>
                            <p class="register-body__text big-padding">Вы можете добавить поставщика с помощью данных полей</p>
                        </div>
                        <div class="register-body__form">
                            <form:form modelAttribute="producer" method="post">
                                <spring:bind path="name">
                                    <div class="form-group">
                                        <form:input type="text" path="name" class="form-control ${status.error ? 'has-error' : ''}" placeholder="Name"></form:input>
                                        <form:errors path="name"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="number">
                                    <div class="form-group ">
                                        <form:input type="text" path="number" class="form-control ${status.error ? 'has-error' : ''}" placeholder="Number"></form:input>
                                        <form:errors path="number"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="address">
                                    <div class="form-group">
                                        <form:input type="text" path="address" class="form-control  ${status.error ? 'has-error' : ''}" placeholder="Address"></form:input>
                                        <form:errors path="address"></form:errors>
                                    </div>
                                </spring:bind>
                                <input type="submit" value="Добавить поставщика">
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