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
        <jsp:include page="shoppingCart.jsp"/>
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
                                    <h2 class="sg-name">${product.name}</h2>
                                    <p class="sg-vendorcode">Артикул: 005</p>
                                    <p class="sg-price">${product.price} грн.</p>
                                    <div class="sg-input">
                                        <p class="sg-input_count">Количество</p>
                                        <input name="quantity" value="1" ref="count" type="text">
                                        <span class="sg-input_up"><i class="fa fa-angle-up" aria-hidden="true"></i></span>
                                        <span class="sg-input_down"><i class="fa fa-angle-down" aria-hidden="true"></i></span>
                                    </div>
                                    <button class="sg-btn">Добавить в корзину</button>
                                </form>
                            </div>11
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
        <jsp:include page="footer.jsp"/>
    </div>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>

</body>
</html>