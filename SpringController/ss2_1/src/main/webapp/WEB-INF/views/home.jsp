<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/15/2023
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" method="post">
    <table>
        <tr>
            <td><label for="lettuce">Lettuce</label></td>
            <td><input type="checkbox" name="ingredient" id="lettuce" value="Lettuce"></td>
            <td><label for="tomato">Tomato</label></td>
            <td><input type="checkbox" name="ingredient" id="tomato" value="Tomato"></td>
            <td><label for="mustard">Mustard</label></td>
            <td><input type="checkbox" name="ingredient" id="mustard" value="Mustard"></td>
            <td><label for="sprouts">Sprouts</label></td>
            <td><input type="checkbox" name="ingredient" id="sprouts" value="Sprouts"></td>
        </tr>
        <tr>
            <td colspan="8"><hr></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>
</body>
</html>
