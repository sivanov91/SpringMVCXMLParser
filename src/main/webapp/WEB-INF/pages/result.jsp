<%@ page import="ru.myproject.domain.Result" %>

<%

    Result result = (Result) request.getAttribute("result");

    if (result == null)
        result = new Result();

%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <td>Сумму всех заказов</td>
        <td>${result.sumAllOrderPrice}</td>
    </tr>

    <tr>
        <td>Клиента с максимальной суммой заказов</td>
        <td>${result.customerWidthMaxSumOrdersPrice}</td>
    </tr>

    <tr>
        <td>Сумму максимального заказа</td>
        <td>${result.sumMaxOrderPrice}</td>
    </tr>

    <tr>
        <td>Сумму минимального заказа</td>
        <td>${result.sumMinOrderPrice}</td>
    </tr>

    <tr>
        <td>Количество заказов</td>
        <td>${result.orderCount}</td>
    </tr>

    <tr>
        <td>Средняя сумма заказа</td>
        <td>${result.avgSumOrderPrice}</td>
    </tr>

    <tr>
        <td>Клиенты с суммой по заказам больше N</td>
        <td>${result.customerSumOrderPriceMoreN}</td>
    </tr>


</table>
</body>
</html>
