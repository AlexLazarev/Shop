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
                <i class="header-acc__user fa fa-user-circle fa-2x" aria-hidden="true"></i>
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
        <div class="content">
            <div class="container">
                <div class="register">
                    <div class="register-title text-center">
                        <h4 class="bold-title">Добавление товара</h4>
                    </div>
                    <div class="register-body">
                        <div class="register-body__info">
                            <p class="register-body__boldtext">Описание</p>
                            <p class="register-body__text big-padding">Вы можете добавить товар с помощью данных полей</p>
                        </div>
                        <div class="register-body__form">
                            <form action="/addProduct" method="post">
                                <p class="register-body__text">Название</p>
                                <input class="register-body__input" type="text" name="name">
                                <p class="register-body__text">Цена</p>
                                <input class="register-body__input" type="text" name="price">
                                <input type="submit" value="Добавить товар">
                            </form>
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