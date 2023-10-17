<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/17/2023
  Time: 11:04 AM
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
        <th>Language:</th>
        <td>${mailBox.languages}</td>
    </tr>
    <tr>
        <th>Page size:</th>
        <td>${mailBox.pageSize}</td>
    </tr>
    <tr>
        <th>Spam filter</th>
        <c:choose>
            <c:when test="${mailBox.spamFilter} == 0">
                <td>
                    Off
                </td>
            </c:when>
            <c:otherwise>
                <td>
                    On
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
    <tr>
        <th>Signature: </th>
        <td>${mailBox.signature}</td>
    </tr>
</table>
</body>
</html>
