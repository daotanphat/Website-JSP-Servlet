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
public class Comment {
    private int cId;
    private Product product;
    private User user;
    private String comment;
    private String vote;
    private Date date;

    public Comment() {
    }

    public Comment(User user, String comment, Date date) {
        this.user = user;
        this.comment = comment;
        this.date = date;
    }

    public Comment(int cId, Product product, User user, String comment, String vote, Date date) {
        this.cId = cId;
        this.product = product;
        this.user = user;
        this.comment = comment;
        this.vote = vote;
        this.date = date;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
