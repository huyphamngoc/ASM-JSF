package controller;

import entity.User;

import javax.faces.bean.ManagedBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@ManagedBean
public class Register {
    Connection connection;
    public String URL = "jdbc:mysql://localhost/java-jsp";
    public String USER = "root";
    public String PASS = "";

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void doSubmit() {
        insert(user);
    }

    public boolean insert(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user (username, password, status) value (?,?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getStatus());
            preparedStatement.execute();
            System.out.println("success Usermodel");
            return true;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
