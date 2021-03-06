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
        <jsp:include page="header.jsp"/>
        <div class="container__admin">
            <div class="table">
                <div class="register-title text-center">
                    <h4 class="bold-title">Заказы</h4>
                </div>
                <div class="table-goods">
                    <div class="table-goods__header">
                        <div class="table-goods__title"><p>#</p></div>
                        <div class="table-goods__title"><p>Дата</p></div>
                        <div class="table-goods__title"><p>ФИО</p></div>
                        <div class="table-goods__title"><p>Email</p></div>
                        <div class="table-goods__title"><p>Город</p></div>
                        <div class="table-goods__title"><p>Способ оплаты</p></div>
                        <div class="table-goods__title"><p>Способ доставки</p></div>
                        <div class="table-goods__title"><p>Товар</p></div>
                        <div class="table-goods__title"><p>Статус</p></div>
                    </div>
                    <c:forEach items="${order}" var="order">
                        <div class="table-goods__item">
                            <div class="table-goods__info item-id"><p>${order.id}</p></div>
                            <div class="table-goods__info item-date"><p>${order.date}</p></div>
                            <c:forEach items="${user}" var="user">
                                <c:choose>
                                    <c:when test="${order.idUser == user.id}">
                                        <div class="table-goods__info item-name"><p>${user.firstName} ${user.lastName}</p></div>
                                        <div class="table-goods__info item-email"><p>${user.email}</p></div>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            <div class="table-goods__info item-city"><p>${order.city}</p></div>
                            <div class="table-goods__info item-payment"><p>${order.payment}</p></div>
                            <div class="table-goods__info item-delivery"><p>${order.delivery}</p></div>
                            <select name="product" class="table-goods__info">
                                <option selected disabled hidden>Список товаров</option>
                                <c:forEach items="${productInOrder}" var="productInOrder">
                                    <c:choose>
                                        <c:when test="${order.id == productInOrder.order.id}">
                                            <c:forEach items="${product}" var="product">
                                                <c:choose>
                                                    <c:when test="${product.id == productInOrder.product.id}">
                                                        <option disabled>${product.name}</option>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </select>
                            <form action="setOrderStatus/${order.id}" method="post" class="table-goods__info">
                                <select name="status"  class="item-status" onchange="this.form.submit()">
                                    <option selected disabled hidden>${order.status}</option>
                                    <option value="В пути">В пути</option>
                                    <option value="Готово">Готово</option>
                                    <option value="Отменено">Отменено</option>
                                </select>
                            </form>
                            <a href="checkOrders/delete${order.id}" class="button-delete">
                                <i class="fa fa-times" aria-hidden="true"></i>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>

</body>
</html>