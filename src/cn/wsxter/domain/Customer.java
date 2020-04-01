package cn.wsxter.domain;

import java.util.Date;

public class Customer {
    private int user_id;
    private  String username;
    private  String password;
    private  String email;
    private  String autograph;
    private int role;
    private Date create_time;

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {

        return role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", autograph='" + autograph + '\'' +
                ", role=" + role +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}