/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Product<T> {
    private int id;
    private String name;
    private String img;
    private float price;
    private int discount;
    private int dateRelease;
    private int quantity;
    private int categoryId;
    private String power;
    private String utilities;
    private String size;
    private String weight;
    private String warranty;
    private String trademark;
    private String firm;
    private T t;

    public Product() {
    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product(T t) {
        this.t = t;
    }

    public Product(int id, String name, int quantity, int categoryId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product(String name, String img, float price, int discount, String utilities) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.utilities = utilities;
    }

    public Product(String name, String img, float price, int discount, int dateRelease, int quantity, int categoryId, String power, String utilities, String size, String weight, String warranty, String trademark, String firm, T t) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.dateRelease = dateRelease;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.power = power;
        this.utilities = utilities;
        this.size = size;
        this.weight = weight;
        this.warranty = warranty;
        this.trademark = trademark;
        this.firm = firm;
        this.t = t;
    }

    public Product(int id, String name, String img, float price, int discount, int categoryId, String utilities) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.categoryId = categoryId;
        this.utilities = utilities;
    }
    
    public Product(int id, String name, String img, float price, int discount, int categoryId, String utilities, String firm, T t) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.categoryId = categoryId;
        this.utilities = utilities;
        this.firm = firm;
        this.t = t;
    }

    public Product(int id, String name, String img, float price, int discount, int categoryId) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.categoryId = categoryId;
    }

    public Product(int id, String name, String img, float price, int discount, int dateRelease, int categoryId, String power, String utilities, String size, String weight, String warranty, String trademark, String firm, T t) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.dateRelease = dateRelease;
        this.categoryId = categoryId;
        this.power = power;
        this.utilities = utilities;
        this.size = size;
        this.weight = weight;
        this.warranty = warranty;
        this.trademark = trademark;
        this.firm = firm;
        this.t = t;
    }

    public Product(int id, String name, String img, float price, int discount, int dateRelease, int quantity, int categoryId, String power, String utilities, String size, String weight, String warranty, String trademark, String firm, T t) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.dateRelease = dateRelease;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.power = power;
        this.utilities = utilities;
        this.size = size;
        this.weight = weight;
        this.warranty = warranty;
        this.trademark = trademark;
        this.firm = firm;
        this.t = t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(int dateRelease) {
        this.dateRelease = dateRelease;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
