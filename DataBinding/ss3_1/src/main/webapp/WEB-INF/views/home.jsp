<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/17/2023
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mailBox" action="update" method="post">
<table>
    <tr>
        <th>Languages</th>
        <td>
            <form:select path="languages">
            <c:forEach items="${languageList}" var="lang">
                <form:option value="${lang}">${lang}</form:option>
            </c:forEach>
            </form:select>
        </td>
    </tr>
    <tr>
        <th>Page size: </th>
        <td>Show <span>
            <form:select path="pageSize">
                <c:forEach items="${numberList}" var="number">
                    <form:option value="${number}">${number}</form:option>
                </c:forEach>
            </form:select>
        </span> emails per page</td>
    </tr>
    <tr>
        <th>Spam filter:</th>
        <td>
            <form:checkbox path="spamFilter"></form:checkbox> <span>Enable spam filter</span>
        </td>
    </tr>
    <tr>
        <th>Signature</th>
        <td>
            <form:textarea path="signature"></form:textarea>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Update">
        </td>
    </tr>
</table>
</form:form>
</body>
</html>
