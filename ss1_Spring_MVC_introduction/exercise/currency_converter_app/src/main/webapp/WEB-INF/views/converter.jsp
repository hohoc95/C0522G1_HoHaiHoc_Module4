<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 10/13/2022
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/exchange" method="get">
    <input type="number" name="money" placeholder="USD" /><br/>
    <input type="submit"  value="Converter"/>
</form>
<p>Kết Quả : ${result}</p>
<p>Converter.io</p>
</body>
</html>