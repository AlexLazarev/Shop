<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
