<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.07.2023
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<ul>
    <c:forEach var="userClass" items="${users}">
        Name:<c:out value="${userClass.name}"/>,
        Age: <c:out value="${userClass.age}"/>,
        Email: <c:out value="${userClass.email}"/>,
        <br>
    </c:forEach>
</ul>
</body>
</html>
