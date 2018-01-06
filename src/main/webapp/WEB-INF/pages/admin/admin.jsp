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
                            <form action="admin/addProduct" method="post">
                                <p class="register-body__text">Тип</p>
                                <input class="register-body__input" type="text" name="type">
                                <p class="register-body__text">Наименование</p>
                                <input class="register-body__input" type="text" name="name">
                                <p class="register-body__text">Цена</p>
                                <input class="register-body__input" type="text" name="price">
                                <p class="register-body__text">Количество</p>
                                <input class="register-body__input" type="text" name="quantity">
                                <p class="register-body__text">Гендер</p>
                                <select name="gender" class="checkout-contact__select">
                                    <option value="male">Мужской</option>
                                    <option value="female">Женский</option>
                                    <option value="unisex">Унисекс</option>
                                </select>
                                <p class="register-body__text">Размер</p>
                                <select name="size" class="checkout-contact__select">
                                    <option value="XXS">XXS</option>
                                    <option value="XS">XS</option>
                                    <option value="S">S</option>
                                    <option value="M">M</option>
                                    <option value="L">L</option>
                                    <option value="XL">XL</option>
                                    <option value="XXL">XXL</option>
                                </select>
                                <p class="register-body__text">Материал</p>
                                <input class="register-body__input" type="text" name="material">
                                <p class="register-body__text">Описание</p>
                                <input class="register-body__input__description" type="text" name="description">
                                <input type="submit" value="Добавить товар">
                                </form>
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