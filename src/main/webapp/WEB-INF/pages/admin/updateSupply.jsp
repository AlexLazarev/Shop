<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <h4 class="bold-title">Добавление поставки</h4>
                    </div>
                    <div class="register-body">
                        <div class="register-body__info">
                            <p class="register-body__boldtext">Описание</p>
                            <p class="register-body__text big-padding">Вы можете обновить поставку с помощью данных полей</p>
                        </div>
                        <div class="register-body__form">
                            <form action="/admin/updateSupply" method="post">
                                <input type="hidden" name="id" value="${supply.id}"/>

                                <select name = "producer.id" value="${suppy.producer.id}" class="checkout-contact__select" >
                                    <option selected disabled hidden>${supply.producer.name}</option>
                                    <c:forEach items="${producers}" var="producer">
                                        <option value="${producer.id}">${producer.name}</option>
                                    </c:forEach>
                                </select>
                                <p class="register-body__text">${supply.date.time}</p>
                                <input class="register-body__input" type="date" value="${supply.date.time}">
                                <input type="submit" value="Обновить поставку">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="footer.jsp"/>
    </div>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>

</body>
</html>