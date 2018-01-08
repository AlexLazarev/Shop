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
            <li class="header-navlist__item"><a class="header-navlist__link" href="addProduct">Товар</a></li>
            <li class="header-navlist__item"><a class="header-navlist__link" href="checkOrders">Заказы</a></li>
            <li class="header-navlist__item"><a class="header-navlist__link" href="addProducer">Поставщики</a></li>
            <li class="header-navlist__item"><a class="header-navlist__link" href="#">Поставка</a></li>
        </ul>
    </div>
    <div class="header-acc">
        <i class="header-acc__user fa fa-user-circle fa-lg" aria-hidden="true"></i>
        <a href="/logout" class="header-acc__text">${pageContext.request.userPrincipal.name} | Выход</a>
    </div>
</header>
</body>
</html>
