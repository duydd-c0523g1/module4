<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/15/2023
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    <td>Count</td>
    <td>Ingredient</td>
  </tr>
  <c:forEach var="ingredient" items="${result}" varStatus="loop">
    <tr>
      <td>${loop.count}</td>
      <td>${ingredient}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
