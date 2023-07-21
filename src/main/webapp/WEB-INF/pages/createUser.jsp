<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>
<form method="post" action="/site" >
    Name:<br>
    <input type="text" name="name" value="${user.name}"/>
    <br/>
    Age:<br>

    <input type="text" name="age" value="${user.age}"/>
    <br/>
    Email:<br>
    <input type="text" name="email" value="${user.email}"/>
    <br/>
    <input type="submit" value="Create!"/>
</form>
</body>
</html>
