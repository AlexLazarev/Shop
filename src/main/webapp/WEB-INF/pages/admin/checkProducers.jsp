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
                    <h4 class="bold-title">Поставщики</h4>
                </div>
                <div class="table-goods">
                    <div class="table-goods__header">
                        <div class="table-producer__title"><p>#</p></div>
                        <div class="table-producer__title"><p>ФИО</p></div>
                        <div class="table-producer__title"><p>Адресс</p></div>
                        <div class="table-producer__title"><p>Номер</p></div>
                        <a href="checkProducers/addProducer" class="button-add">
                            <i class="fa fa-plus" aria-hidden="true"></i>
                        </a>
                       </div>
                    <c:forEach items="${producers}" var="producer">
                    <div class="table-goods__item">
                        <div class="table-producer__info item-id"><p>${producer.id}</p></div>
                        <div class="table-producer__info item-name"><p>${producer.name}</p></div>
                        <div class="table-producer__info item-adress"><p>${producer.address}</p></div>
                        <div class="table-producer__info item-number"><p>${producer.number}</p></div>

                        <a href="checkProducers/updateProducer-${producer.id}" class="button-update">
                            <i class="fa fa-refresh" aria-hidden="true"></i>
                        </a>
                        <a href="checkProducers/delete${producer.id}" class="button-delete">
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