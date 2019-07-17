package entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class User {
    private String username;
    private String password;
    private int status;

    public User() {
    }

    public User(String username, String password, int status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
