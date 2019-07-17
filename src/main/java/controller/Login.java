package controller;

import entity.User;

import javax.faces.bean.ManagedBean;
import java.sql.*;

@ManagedBean

public class Login {
    Connection connection;
    public String URL = "jdbc:mysql://localhost/java-jsp";
    public String USER = "root";
    public String PASS = "";
    private User user = new User();

    public User getUser() {
        return user;
    }

    public String doSubmit() {
        if (select(user)){
            return "home-page";
        }
        return "login";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean select(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ? and password= ?");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
