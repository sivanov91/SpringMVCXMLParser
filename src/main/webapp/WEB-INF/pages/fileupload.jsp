<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage == null)
        errorMessage = "";
%>

<html>
<body>
<form:form enctype="multipart/form-data" method="POST" modelAttribute="uploadFile">
    <table>


        <tr>
            <td><form:label path="file">Файл: </form:label></td>
            <td><form:input type="file" path="file"/></td>
        </tr>

        <tr>
            <td><form:label path="sumOrderPriceN">N: </form:label></td>
            <td><form:input path="sumOrderPriceN"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Отправить"/></td>
        </tr>


    </table>
</form:form>

<% if (!errorMessage.equals("")) { %>
<table>
    <tr>
        <td>В процессе загрузки произошла ошибка.</td>
    </tr>
    <tr>
        <td><%=errorMessage%></td>
    </tr>
</table>
<% } %>
</body>
</html>
