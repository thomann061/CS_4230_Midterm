<%--
  Created by IntelliJ IDEA.
  User: jthomann
  Date: 10/24/16
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Parts</title>
</head>
<body>
<%
    List<Part> parts = (List<Part>) request.getAttribute("parts");
    request.setAttribute("parts", parts);
%>
<c:forEach items='${parts}' var="el">
    <tr>
        <td>${el.id}</td>
        <td>${el.partNumber}</td>
        <td>${el.description}</td>
        <td>${el.cost}</td>
    </tr>
</c:forEach>
</body>
</html>
