<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 10/14/2022
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sandwich Spice</title>
</head>
<body>
<h1 >SANDWICH CONDIMENTS</h1>
<form action="/save" method="get">
  <input type="checkbox" value="Lettuce" name="condiment"><b>Lettuce</b>
  <input type="checkbox" value="Tomato" name="condiment"><b>Tomato</b>
  <input type="checkbox" value="Mustard" name="condiment"><b>Mustard</b>
  <input type="checkbox" value="Sprouts" name="condiment"><b>Sprouts</b>
  <hr>
  <button type="submit">Save</button>
  <c:forEach items="${condiment}" var="cond">
    <p>${cond}</p>
  </c:forEach>
</form>
</body>
</html>
