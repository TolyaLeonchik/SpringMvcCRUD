<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.07.2023
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updating Information Page</title>
</head>
<body>
    <form method="post" action="/site/${user.id}">
      <input type="hidden" name="_method" value="POST">
      <label for="name">Enter name</label>
      <input type="text" id="name" name="name" value="${user.name}">
        <br>
      <label for="age">Enter age</label>
      <input type="text" id="age" name="age" value="${user.age}">
        <br>
      <label for="email">Enter email</label>
      <input type="text" id="email" name="email" value="${user.email}">
        <br>
        <input type="submit" value="Update"/>
    </form>
</body>
</html>
