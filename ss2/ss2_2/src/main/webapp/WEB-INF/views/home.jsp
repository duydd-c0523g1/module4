<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/15/2023
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate" method="post">
  <table>
    <tr>
      <td><input type="number" required placeholder="Number 1" name="num1"></td>
      <td><select name="operator" id="operator">
        <option value="addition">+</option>
        <option value="subtraction">-</option>
        <option value="multiply">x</option>
        <option value="division">:</option>
      </select></td>
      <td><input type="number" required placeholder="Number 2" name="num2"></td>
      <td><input type="submit" value="Calculate"></td>
    </tr>
    <tr>
      <td colspan="4">Result: ${result}</td>
    </tr>
  </table>
</form>
</body>
</html>
