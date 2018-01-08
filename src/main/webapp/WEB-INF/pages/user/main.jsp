<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
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

        <div class="content default">
            <div class="home">
                <div class="container default-box">
                    <div class="middle-block">
                        <h2 class="middle-block__title main-title font-TNR">Осень и зима</h2>
                        <a class="middle-block__btn" href="shop">В магазин</a>
                    </div>
                </div>
            </div>
            <div class="bottom-content">
                <div class="separator">
                    <div class="container default-box">
                        <p class="separator__text">Бесплатная доставка по Украине(нет)</p>
                    </div>
                </div>
                <div class="container default-box">
                    <div class="text-center">
                        <h3 class="bottom-content__title font-TNR main-title">Круглый год</h3>
                        <div class="line line__main"></div>
                        <h4 class="bottom-content__subtitle font-Arial">Обязательные вещи в вашем гардеробе</h4>
                    </div>
                    <div class="goods">
                        <div class="goods-box">
                            <div class="goods-name">
                                <p class="goods-box__text font-Arial">Чет крутое</p>
                            </div>
                        </div>
                        <div class="goods-box2">
                            <div class="goods-title">
                                <p class="goods-box2__text font-TNR">Скидки</p>
                            </div>
                        </div>
                        <div class="goods-box">
                            <div class="goods-name">
                                <p class="goods-box__text font-Arial">Круче чем слева</p>
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