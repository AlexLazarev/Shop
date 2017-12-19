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
        <div class="recyclebin">
            <div class="recyclebin-header">
                <h3 class="recyclebin-header_title">Корзина</h3>
                <i class="recyclebin-header__back fa fa-angle-right fa-2x" aria-hidden="true"></i>
            </div>
            <div class="recyclebin-info">
                <div class="recyclebin-info_box">
                    <c:forEach items="${productInOrder}" var="product">
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
                    </c:forEach>
                </div>
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
        <div class="content selected-goods">
            <div class="container default-box">
                <div class="sg-nav clearfix">
                    <ul class="sg-nav_list">
                        <li class="sg-nav_list__item">
                            <a class="sg-nav_list__link" href="main">Главная</a>
                        </li>
                        <li class="sg-nav_list__item">
                            <a class="sg-nav_list__link" href="shop">Магазин</a>
                        </li>
                        <li class="sg-nav_list__item">
                            <a class="sg-nav_list__link" href="#">Ваш товар</a>
                        </li>
                    </ul>
                    <ul class="sg-nav_pn">
                        <li class="sg-nav_pn__item">
                            <a class="sg-nav_pn__link" href="${product.id-1}">Назад</a>
                        </li>
                        <li class="sg-nav_pn__item">
                            <a class="sg-nav_pn__link" href="${product.id+1}">Вперед</a>
                        </li>
                    </ul>
                </div>
                <div class="sg-info">
                    <div class="sg-info_img">
                        <div class="sg-info_img__img"></div>
                        <div class="sg-info_img__text">
                            <p class="sg-text">Это описание товара. Здесь вы можете рассказать о товаре подробнее: напишите о размерах, материалах, уходе и любых других важных моментах.</p>
                        </div>
                    </div>
                    <div class="sg-info_description">
                        <div class="sg-info_description__totalinfo sg-box">
                            <div>
                                <form action="/addToShoppingCart/${product.id}" method="post">
                                    <h2 class="sg-name"><c:out value="${product.name}"/></h2>
                                    <p class="sg-vendorcode">Артикул: 005</p>
                                    <p class="sg-price"><c:out value="${product.price}"/> грн.</p>
                                    <div class="sg-input">
                                        <p class="sg-input_count">Количество</p>
                                        <input name="idCustomer" value="1" ref="count" type="text">
                                        <span class="sg-input_up"><i class="fa fa-angle-up" aria-hidden="true"></i></span>
                                        <span class="sg-input_down"><i class="fa fa-angle-down" aria-hidden="true"></i></span>
                                    </div>
                                    <button class="sg-btn">Добавить в корзину</button>
                                </form>
                            </div>
                        </div>
                        <div class="sg-info_description__detailinfo sg-box">
                            <h3 class="sg-di_title">О товаре</h3>
                            <p class="sg-text">Это информация о товаре. Расскажите подробно, что он из себя представляет, и перечислите всю необходимую информацию: размеры, материалы, инструкции по уходу и т. д. Это также хорошая возможность сообщить, в чем особенность вашей продукции и какую выгоду покупатели получат в итоге. Подробные сведения о товаре помогут вашим посетителям определиться с покупкой.</p>
                        </div>
                        <div class="sg-info_description__detailinfo sg-box">
                            <h3 class="sg-di_title">Политика возврата</h3>
                            <p class="sg-text">Это правила и условия возврата товара и денег. Расскажите посетителям, что нужно сделать, если они захотят вернуть товар и получить назад свои деньги. Четкая и ясная политика возврата — это хороший способ построить доверительные отношения с клиентами.</p>
                        </div>
                        <div class="sg-info_description__soc">
                            <i class="sg-info_description__link fa fa-twitter" aria-hidden="true"></i>
                            <i class="sg-info_description__link fa fa-facebook fa-lg" aria-hidden="true"></i>
                            <i class="sg-info_description__link fa fa-google-plus" aria-hidden="true"></i>
                            <i class="sg-info_description__link fa fa-pinterest" aria-hidden="true"></i>
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