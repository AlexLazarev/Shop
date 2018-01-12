<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>

</head>
<div class="recyclebin">
    <div class="recyclebin-header">
        <h3 class="recyclebin-header_title">Корзина</h3>
        <i class="recyclebin-header__back fa fa-angle-right fa-lg" aria-hidden="true"></i>
    </div>
    <div class="recyclebin-info">
        <c:forEach items="${shoppingCart}" var="product">
            <div class="recyclebin-info_box">
                <div class="recyclebin-info_box__img">
                    <img src="https://static.wixstatic.com/media/cda177_f95b14c95d6446de847782f0b6fd0027.png/v1/fill/w_298,h_355,q_85,usm_0.66_1.00_0.01/cda177_f95b14c95d6446de847782f0b6fd0027.png" alt="Ваш товар"/>
                </div>
                <div class="recyclebin-info_box__info">
                    <p class="recyclebin-title"><c:out value="${product.key.name}"/></p>
                    <p class="recyclebin-text"><c:out value="${product.key.price}"/> грн.</p>
                    <p class="recyclebin-text"><c:out value="${product.value}"/> штук.</p>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="recyclebin-sum">
        <div class="recyclebin-sum">
            <p class="recyclebin-sum_text">Сумма</p>
            <p class="recyclebin-sum_text">${sum}</p>
        </div>
    </div>
    <div class='recyclebin-footer rb-border'>
        <a href="/checkout" class="recyclebin-footer_btn">Перейти в корзину</a>
    </div>
</div>

<body>

</body>
</html>
