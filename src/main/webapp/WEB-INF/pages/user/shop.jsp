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
        <div class="content">
            <div class="container">
                <div class="shop-goods">
                    <div class="shop-goods__title text-center">
                        <h4 class="bold-title">Магазин</h4>
                    </div>
                    <div class="shop-goods__allGoods">
                        <c:forEach items="${products}" var="product">
                        <div class="shop-goods__item">
                            <a href="selected/${product.id}"><div class="shop-goods__img"></div></a>
                            <div class="shop-goods__link">
                                <p class="shop-goods__text">${product.name}</p>
                                <p class="shop-goods__text">${product.price} грн.</p>
                            </div>
                        </div>
                        </c:forEach>
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