<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                        <h4 class="bold-title">Обновление товара</h4>
                    </div>
                    <div class="register-body">
                        <div class="register-body__info">
                            <p class="register-body__boldtext">Описание</p>
                            <p class="register-body__text big-padding">Вы можете  обновить товар с помощью данных полей</p>
                        </div>
                        <div class="register-body__form">
                            <form:form modelAttribute="product" method="post" action="/admin/addProduct">
                                <form:hidden path="id" value="${product.id}"/>

                                <spring:bind path="type">
                                    <div class="form-group">
                                        <form:input type="text" path="type" class="form-control ${status.error ? 'has-error' : ''}" placeholder="Type"></form:input>
                                        <form:errors path="type"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="name">
                                    <div class="form-group">
                                        <form:input type="text" path="name" class="form-control ${status.error ? 'has-error' : ''}" placeholder="Name"></form:input>
                                        <form:errors path="name"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="price">
                                    <div class="form-group">
                                        <form:input type="text" path="price" class="form-control ${status.error ? 'has-error' : ''}" placeholder="Price"></form:input>
                                        <form:errors path="price"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="quantity">
                                    <div class="form-group">
                                        <form:input type="text" path="quantity" class="form-control ${status.error ? 'has-error' : ''}" placeholder="Quantity"></form:input>
                                        <form:errors path="quantity"></form:errors>
                                    </div>
                                </spring:bind>
                                <div class="form-group">
                                    <select name="gender" class="form-control">
                                        <option value="male">Мужской</option>
                                        <option value="female">Женский</option>
                                        <option value="unisex">Унисекс</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <select name="size" class="form-control">
                                        <option value="XXS">XXS</option>
                                        <option value="XS">XS</option>
                                        <option value="S">S</option>
                                        <option value="M">M</option>
                                        <option value="L">L</option>
                                        <option value="XL">XL</option>
                                        <option value="XXL">XXL</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <select name="supply.id" class="form-control">
                                        <c:forEach items="${supplies}" var="supply">
                                            <option value="${supply.id}">${supply.producer.name} — ${supply.date}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <spring:bind path="material">
                                    <div class="form-group">
                                        <form:input type="text" path="material" class="form-control ${status.error ? 'has-error' : ''}" placeholder="Material"></form:input>
                                        <form:errors path="material"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="description">
                                    <div class="form-group">
                                        <form:textarea path="description" cols="30" rows="10" class="form-control" placeholder="Description..."></form:textarea>
                                        <form:errors path="description"></form:errors>
                                    </div>
                                </spring:bind>

                                <input type="submit" value="Обновить товар">
                                </form:form>
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