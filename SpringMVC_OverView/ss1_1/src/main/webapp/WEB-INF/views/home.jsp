<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/12/2023
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate">
    <table>
        <tr>
            <td><input type="number" required placeholder="Nhập số tiền" name="input"></td>
            <td>
                <select name="currency" id="currency">
                    <option value="vnd">VND</option>
                    <option value="usd">USD</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Kết quả:</td>
            <td>${result}</td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Chuyển đổi">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
