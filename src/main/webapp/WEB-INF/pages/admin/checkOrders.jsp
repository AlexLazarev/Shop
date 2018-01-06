<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <div class="container__admin">
                <div class="register-title text-center">
                    <h4 class="bold-title">Заказы</h4>
                </div>
                <div class="table-goods">
                    <div class="table-goods__header">
                        <div class="table-goods__title"><p>Имя</p></div>
                        <div class="table-goods__title"><p>Фамилия</p></div>
                        <div class="table-goods__title"><p>Город</p></div>
                        <div class="table-goods__title"><p>Email</p></div>
                        <div class="table-goods__title"><p>Способ оплаты</p></div>
                        <div class="table-goods__title"><p>Способ доставки</p></div>
                        <div class="table-goods__title"><p>Товар</p></div>
                        <div class="table-goods__title"><p>Количество</p></div>
                    </div>
                    <c:forEach items="${order}" var="order">
                        <div class="table-goods__item">
                            <div class="table-goods__info item-name"><p>${order.id}</p></div>
                            <div class="table-goods__info item-surname"><p>${order.idUser}</p></div>
                            <div class="table-goods__info item-city"><p>${order.payment}</p></div>
                            <div class="table-goods__info item-email"><p>${order.delivery}</p></div>
                            <c:forEach items="${order}" var="order">
                                <c:choose>
                                    <c:when test="${order.idCustomer == user.id}">
                                        <div class="table-goods__info item-pay"><p>${order.payment}</p></div>
                                        <div class="table-goods__info item-delivery"><p>${order.delivery}</p></div>
                                        <div class="table-goods__info item-goods"><p>text</p></div>
                                        <div class="table-goods__info item-count"><p>text</p></div>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </div>

                    </c:forEach>
                </div>
            </div>
    </div>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>

</body>
</html>