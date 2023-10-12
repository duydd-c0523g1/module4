<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/12/2023
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translate">
    <table>
        <tr>
            <td><input type="text" placeholder="Nhập từ tiếng And" required name="input"></td>
            <td><input type="submit" value="Dịch"></td>
        </tr>
        <tr>
            <td>Kết quả:</td>
            <td>${result}</td>
        </tr>
    </table>
</form>
</body>
</html>
