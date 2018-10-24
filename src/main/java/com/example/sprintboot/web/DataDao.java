package com.example.sprintboot.web;

public class DataDao {
    public String username;
    public String password;

    public DataDao(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "DataDao{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
