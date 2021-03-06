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
        <header class="header">
            <div class="container default-box clearfix">
                <div class="header-logo">
                    <h1 class="header-logo__text">
                        <a href="#">FLO</a>
                    </h1>
                </div>
                <ul class="header-navlist">
                    <li class="header-navlist__item"><a class="header-navlist__link" href="main">Главная</a></li>
                    <li class="header-navlist__item"><a class="header-navlist__link" href="shop">Магазин</a></li>
                    <li class="header-navlist__item"><a class="header-navlist__link" href="#">Распродажа</a></li>
                    <li class="header-navlist__item"><a class="header-navlist__link" href="#">Помощь покупателям</a></li>
                    <li class="header-navlist__item"><a class="header-navlist__link" href="#">Адреса</a></li>
                </ul>
                <div class="header-rbcount">
                    <i class="fa fa-shopping-bag fa-2x" aria-hidden="true"></i>
                </div>
            </div>
            <div class="header-acc">
                <i class="header-acc__user fa fa-user-circle fa-lg" aria-hidden="true"></i>
                <a href="#" class="header-acc__text">Войти в личный кабинет</a>
            </div>
            <div class="header-accwindow">
                <h4 class="header-accwindow__title">Вход в интернет-магазин</h4>
                <form class="header-accwindow__form" action="#">
                    <p class="header-accwindow__text">Эл. почта или телефон</p>
                    <input class="header-accwindow__input" type="text">
                    <p class="header-accwindow__text">Пароль</p>
                    <input class="header-accwindow__input" type="password">
                    <input class="header-accwindow__btn" type="submit" value="Войти">
                    <a class="header-accwindow__close" href="#">Отмена</a>
                </form>
                <a class="header-accwindow__reg" href="register">Зарегистрироваться</a>
            </div>
        </header>
        <div class="recyclebin">
            <div class="recyclebin-header">
                <h3 class="recyclebin-header_title">Корзина</h3>
                <i class="recyclebin-header__back fa fa-angle-right fa-2x" aria-hidden="true"></i>
            </div>
            <div class="recyclebin-info">
                <c:forEach items="${shoppingCart}" var="product">
                    <div class="recyclebin-info_box">
                        <div class="recyclebin-info_box__img">
                            <img src="https://static.wixstatic.com/media/cda177_f95b14c95d6446de847782f0b6fd0027.png/v1/fill/w_298,h_355,q_85,usm_0.66_1.00_0.01/cda177_f95b14c95d6446de847782f0b6fd0027.png" alt="Ваш товар"/>
                        </div>
                        <div class="recyclebin-info_box__info">
                            <p class="recyclebin-title"><c:out value="${product.name}"/></p>
                            <p class="recyclebin-text"><c:out value="${product.price}"/> грн.</p>
                        </div>
                        <a href="#" class="recyclebin-info_box__btn">
                            <i class="fa fa-times" aria-hidden="true"></i>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="recyclebin-sum">
                <div class="recyclebin-sum">
                    <p class="recyclebin-sum_text">Сумма</p>
                    <p class="recyclebin-sum_text">1999 грн.</p>
                </div>
            </div>
            <div class='recyclebin-footer rb-border'>
                <a href="#" class="recyclebin-footer_btn">Перейти в корзину</a>
            </div>
        </div>
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
                                <p class="checkout-contact__text">Имя</p>
                                <input class="checkout-contact__input" type="text" name="firstName">
                                <p class="checkout-contact__text">Фамилия</p>
                                <input class="checkout-contact__input" type="text" name="lastName">
                                <p class="checkout-contact__text">Город</p>
                                <input class="checkout-contact__input" type="text" name="city">
                                <p class="checkout-contact__text">email</p>
                                <input class="checkout-contact__input" type="text" name="email">
                                <p class="checkout-contact__text">Способ доставки</p>
                                <select name="delivery" class="checkout-contact__select">
                                    <option value="PickUp">Самовывоз из Новой Почты</option>
                                    <option value="NEW MAIL">Курьер Новая Почта</option>
                                    <option value="Курьер Мист Экспресс">Курьер Мист Экспресс</option>
                                </select>
                                <p class="checkout-contact__text">Способ оплаты</p>
                                <select name="payment" class="checkout-contact__select">
                                    <option value="Cash">Наличными</option>
                                    <option value="Credit">Кредит</option>
                                    <option value="WebMoney">WebMoney</option>
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
                                        <p> ${product.name}</p>
                                        <p class="grey">Артикул: 0011</p>
                                        <a href="#">Удалить</a>
                                    </div>
                                    <ul class="checkout-goods__price">
                                        <li><p>${product.price}</p></li>
                                        <li><input class="checkout-goods__input" value="1" type="text"></li>
                                        <li><p>${product.price}</p></li>
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
        <footer class="footer">
            <div class="container default-box">
                <div class="footer-info">
                    <div class="footer-info__box">
                        <p class="footer-info__title">Будем на связи</p>
                        <ul class="soc">
                            <li class="soc_item">
                                <a class="soc_link" href="#"><i class="fa fa-vk" aria-hidden="true"></i></a>
                            </li>
                            <li class="soc_item">
                                <a class="soc_link" href="#"><i class="fa fa-facebook fa-lg" aria-hidden="true"></i></a>
                            </li>
                            <li class="soc_item">
                                <a class="soc_link" href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                            </li>
                            <li class="soc_item">
                                <a class="soc_link" href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="footer-info__box">
                        <p class="footer-info__title">Давайте дружить</p>
                        <input class="ftr-input" type="text" placeholder="Ваш email"/>
                        <button class="ftr-btn">Подписаться на новости</button>
                    </div>
                    <div class="footer-info__box">
                        <p class="footer-info__title">Нужна помощь?</p>
                        <p class="footer-info__text">+7 (495) 000-00-00</p>
                        <a href="#" class="footer-info__text">info@mysite.ru</a>
                    </div>
                </div>
                <div class="bottom-ftr text-center">
                    <p class="bottom-ftr__text">© 2023 МАГАЗИН ЖЕНСКОЙ ОДЕЖДЫ «FLO».</p>
                </div>
            </div>
        </footer>
    </div>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
</body>
</html>