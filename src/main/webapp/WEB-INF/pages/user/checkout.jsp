<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="content">
            <div class="container">
                <div class="checkout">
                    <div class="checkout-title text-center">
                        <h4 class="bold-title">Оформление заказа</h4>
                    </div>
                    <div class="checkout-contact">
                        <div class="checkout-contact__info">
                            <p class="checkout-contact__boldtext">Заполнение формы</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur et veniam vero!</p>
                        </div>
                        <div class="checkout-contact__form">
                            <form action="/makeOrder" method="post">
                                <input type="hidden" value="${user.id}" name="idUser">
                                <p class="checkout-contact__text">Имя</p>
                                <input class="form-control" type="text" value="${user.firstName}" name="firstName">
                                <p class="checkout-contact__text">Фамилия</p>
                                <input class="form-control" type="text" value="${user.lastName}" name="lastName">
                                <p class="checkout-contact__text">email</p>
                                <input class="form-control" type="text" value="${user.email}" name="email">
                                <p class="checkout-contact__text">Город</p>
                                <input class="form-control" type="text" name="city">
                                <p class="checkout-contact__text">Способ доставки</p>
                                <select name="delivery" class="form-control">
                                    <option value="Самовывоз из Новой Почты">Самовывоз из Новой Почты</option>
                                    <option value="Курьер Новая Почта">Курьер Новая Почта</option>
                                    <option value="Самовывоз с магазина">Самовывоз с магазина</option>
                                </select>
                                <p class="checkout-contact__text">Способ оплаты</p>
                                <select name="payment" class="form-control">
                                    <option value="Наличными">Наличными</option>
                                    <option value="Кредит">Кредит</option>
                                    <option value="Bitcoin">Bitcoin</option>
                                </select>
                                <input type="submit" value="Заказать">
                            </form>
                        </div>
                    </div>
                    <div class="checkout-goods">
                        <div class="checkout-goods__head clearfix">
                            <div class="checkout-goods__title">
                                <h4>Моя корзина</h4>
                            </div>
                            <ul class="checkout-goods__chracteristic">
                                <li><p>Цена</p></li>
                                <li><p>К-во</p></li>
                                <li><p>Итого</p></li>
                            </ul>
                        </div>
                        <div class="checkout-goods__body">
                            <c:forEach items="${shoppingCart}" var="product">
                            <div class="checkout-goods__eachgoods">
                                <div class="checkout-goods__info clearfix">

                                    <div class="checkout-goods__img">
                                        <img src="https://static.wixstatic.com/media/cda177_f95b14c95d6446de847782f0b6fd0027.png/v1/fill/w_298,h_355,q_85,usm_0.66_1.00_0.01/cda177_f95b14c95d6446de847782f0b6fd0027.png" alt="">
                                    </div>
                                    <div class="checkout-goods__di">
                                        <p> ${product.key.name}</p>
                                        <p class="grey">Артикул: 0011</p>
                                        <a href="/remove/${product.key.id}">Удалить</a>
                                    </div>
                                    <ul class="checkout-goods__price">
                                        <li><p>${product.key.price}</p></li>
                                        <li><p>${product.value}</p></li>
                                        <li><p>${product.value * product.key.price}</p></li>
                                    </ul>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                        <div class="checkout-goods__sum">
                            <div class="checkout-goods__total">
                                <p>Сумма</p>
                                <p>${sum}</p>
                            </div>
                        </div>
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