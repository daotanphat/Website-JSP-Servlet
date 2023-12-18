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
public class Order {
    private int oid;
    private User user;
    private String orderDate;
    private float totalMoney;

    public Order() {
    }

    public Order(int oid, User user, String orderDate) {
        this.oid = oid;
        this.user = user;
        this.orderDate = orderDate;
    }

    public Order(int oid, User user, String orderDate, float totalMoney) {
        this.oid = oid;
        this.user = user;
        this.orderDate = orderDate;
        this.totalMoney = totalMoney;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
