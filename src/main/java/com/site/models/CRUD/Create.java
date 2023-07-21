package com.site.models.CRUD;

import com.site.models.UserClass;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Create {
    public UserClass createUser(HttpServletRequest request) {
        UserClass addUser = new UserClass();
        String idString = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageString = request.getParameter("age");
        int age = Integer.parseInt(ageString);
        int id = Integer.parseInt(idString);

        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test_db", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("Insert Into person" +
                    "(id,name,age,email)\n" +
                    "VALUES (?, ?, ?, ?);");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setString(4, email);

            addUser.setId(id);
            addUser.setName(name);
            addUser.setAge(age);
            addUser.setEmail(email);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addUser;
    }
}
