/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class User {
    private int userId;
    private String name;
    private boolean gender;
    private Date date;
    private String address;
    private String email;
    private String phone;
    private String username;
    private String password;
    private int role;
    private String avatar;

    public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String name, String avatar) {
        this.userId = userId;
        this.name = name;
        this.avatar = avatar;
    }

    public User(int userId, String name, boolean gender, Date date, String address, String email, String phone, String username, String password, int role) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User(String name, boolean gender, Date date, String address, String email, String phone, String username, String password) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
    
    public User(String name, boolean gender, Date date, String address, String email, String phone, String username, String password, String avatar) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }

    public User(int userId, String name, boolean gender, Date date, String address, String email, String phone, String username, String password, int role, String avatar) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
    }
    
    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
