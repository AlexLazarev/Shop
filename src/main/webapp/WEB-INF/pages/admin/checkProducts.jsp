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
        <div class="container__producer">
            <div class="table">
                <div class="register-title text-center">
                    <h4 class="bold-title">Товары</h4>
                </div>
                <div class="table-goods">
                    <div class="table-goods__header">
                        <div class="table-product__title"><p>#</p></div>
                        <div class="table-product__title"><p>Тип</p></div>
                        <div class="table-product__title"><p>Наименование</p></div>
                        <div class="table-product__title"><p>Цена</p></div>
                        <div class="table-product__title"><p>Поставка</p></div>
                        <a href="checkProducts/addProduct" class="button-add">
                            <i class="fa fa-plus" aria-hidden="true"></i>
                        </a>
                       </div>
                    <c:forEach items="${products}" var="product">
                    <div class="table-goods__item">
                        <div class="table-product__info item-id"><p>${product.id}</p></div>
                        <div class="table-product__info item-name"><p>${product.type}</p></div>
                        <div class="table-product__info item-adress"><p>${product.name}</p></div>
                        <div class="table-product__info item-number"><p>${product.price}</p></div>
                        <div class="table-product__info item-supply"><p>${product.supply.date}</p></div>

                        <a href="checkProducts/update-${product.id}" class="button-update">
                            <i class="fa fa-refresh" aria-hidden="true"></i>
                        </a>
                        <a href="checkProducts/delete-${product.id}" class="button-delete">
                            <i class="fa fa-times" aria-hidden="true"></i>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>

</body>
</html>