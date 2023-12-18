/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Blender;
import model.Cart;
import model.Category;
import model.Comment;
import model.ElectricStove;
import model.ExtractorHood;
import model.Item;
import model.Microwave;
import model.Order;
import model.Refrigerator;
import model.WaterPurifier;
import model.Product;
import model.User;
import model.Vn_Pay;

/**
 *
 * @author Asus
 */
public class DAO extends DBContext {

    // get all categories
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement st = Connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("categoryId"), rs.getString("categoryName"), rs.getString("img"));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // log in into webstie
    public User logIn(String username, String pass) {
        String sql = "select * from [User]\n"
                + "where username = ?\n"
                + "and password = ?";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getString("name"), rs.getBoolean("gender"), rs.getDate("date"), rs.getString("address"), rs.getString("email"), rs.getString("phone"), rs.getString("username"), rs.getString("password"), rs.getInt("role"), rs.getString("avatar"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // log in into webstie
    public User logIn(String username, String pass, int role) {
        String sql = "select * from [User]\n"
                + "where username = ?\n"
                + "and password = ?\n"
                + "and role = ?";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setInt(3, role);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getString("name"), rs.getBoolean("gender"), rs.getDate("date"), rs.getString("address"), rs.getString("email"), rs.getString("phone"), rs.getString("username"), rs.getString("password"), rs.getInt("role"), rs.getString("avatar"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // check exist account
    public User logIn(String username) {
        String sql = "select * from [User]\n"
                + "where username = ?";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getString("name"), rs.getBoolean("gender"), rs.getDate("date"), rs.getString("address"), rs.getString("email"), rs.getString("phone"), rs.getString("username"), rs.getString("password"), rs.getInt("role"), rs.getString("avatar"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // sign up account and use sql INSERT to push data into database
    public void signUp(User u) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([name]\n"
                + "           ,[gender]\n"
                + "           ,[date]\n"
                + "           ,[address]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[role]\n"
                + "           ,[avatar])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setBoolean(2, u.isGender());
            ps.setDate(3, u.getDate());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getPhone());
            ps.setString(7, u.getUsername());
            ps.setString(8, u.getPassword());
            ps.setInt(9, 2);
            ps.setString(10, "./assets/img/Information/user.png");
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // get feature product
    public List<Product> getFeatureProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "WITH CTE AS (\n"
                + "  SELECT *,\n"
                + "         ROW_NUMBER() OVER (PARTITION BY categoryId ORDER BY date_release DESC) AS rn\n"
                + "  FROM Product\n"
                + "  WHERE categoryId IN (1, 2, 3, 4, 5, 6)\n"
                + ")\n"
                + "SELECT *\n"
                + "FROM CTE\n"
                + "WHERE rn = 1;";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                String img = rs.getString("img");
                String utilities = rs.getString("utilities");
                int categoryId = rs.getInt("categoryId");

                Product p = new Product(id, name, img, price, discount, categoryId, utilities);
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    // update password of user
    public void changePass(String username, String newpass) {
        String sql = "update [User]\n"
                + "set password =  '" + newpass + "'\n"
                + "where username = '" + username + "'";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // update information user
    public void updateInfor(String username, User u) {
        String sql = "update [User]\n"
                + "set name = ?,\n"
                + "gender = ?,\n"
                + "date = ?,\n"
                + "address = ?,\n"
                + "email = ?,\n"
                + "phone = ?,\n"
                + "avatar = ?\n"
                + "where username = '" + username + "'";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setBoolean(2, u.isGender());
            ps.setDate(3, u.getDate());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getPhone());
            ps.setString(7, u.getAvatar());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Display product by category id
    public List<Product> displayProduct(int cateId) {
        String sql = "select * \n"
                + "from Product\n"
                + "where categoryId = " + cateId;
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                String utilities = rs.getString("utilities");
                int categoryId = rs.getInt("categoryId");
                Product p = new Product(id, name, img, price, discount, categoryId, utilities);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Display product by product id
    public Product getProductById(int pid) {
        String sql = "select * \n"
                + "from Product\n"
                + "where id = " + pid;
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int date = rs.getInt("date_release");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String power = rs.getString("power");
                String utilities = rs.getString("utilities");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String warranty = rs.getString("warranty");
                String trademark = rs.getString("trademark");
                String firm = rs.getString("firm");
                return new Product(id, name, img, price, discount, date, quantity, categoryId, power, utilities, size, weight, warranty, trademark, firm, null);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // Display all product
    public List<Product> displayAllProduct() {
        String sql = "select * \n"
                + "from Product\n"
                + "order by categoryId asc";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                Product p = new Product(id, name, quantity, categoryId);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Sorted by feartured product
    public List<Product> fearturedProduct(int cateId) {
        String sql = "select * \n"
                + "from Product\n"
                + "where categoryId = " + cateId + "\n"
                + "order by date_release desc";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                String utilities = rs.getString("utilities");
                int categoryId = rs.getInt("categoryId");
                Product p = new Product(id, name, img, price, discount, categoryId, utilities);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Sorted by high to low price product
    public List<Product> htlProduct(int cateId) {
        String sql = "select * \n"
                + "from Product\n"
                + "where categoryId = " + cateId + "\n"
                + "order by (price-(price*discount/100)) desc";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                String utilities = rs.getString("utilities");
                int categoryId = rs.getInt("categoryId");
                Product p = new Product(id, name, img, price, discount, categoryId, utilities);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Sorted by high to low price product
    public List<Product> lthProduct(int cateId) {
        String sql = "select * \n"
                + "from Product\n"
                + "where categoryId = " + cateId + "\n"
                + "order by (price-(price*discount/100)) asc";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                String utilities = rs.getString("utilities");
                int categoryId = rs.getInt("categoryId");
                Product p = new Product(id, name, img, price, discount, categoryId, utilities);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Search product
    public List<Product> searchProduct(String key, int cid) {
        String sql = "select * \n"
                + "from Product\n"
                + "where categoryId = " + cid + "\n"
                + "and name like ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                String utilities = rs.getString("utilities");
                int categoryId = rs.getInt("categoryId");
                Product p = new Product(id, name, img, price, discount, categoryId, utilities);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Filter product
    public List<Product> filterProduct(String table, int cateid, String[] productTypes, String[] productFirms) {
        String sql = "select * from Product as p\n"
                + "join " + table + " as e\n"
                + "on p.id = e.productId\n"
                + "where 1 = 1\n";
        if (productTypes != null) {
            sql += "and e.type in (";
            for (int i = 0; i < productTypes.length; i++) {
                sql += "'" + productTypes[i] + "'" + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")\n";
        }

        if (productFirms != null) {
            sql += "and p.firm in (";
            for (int i = 0; i < productFirms.length; i++) {
                sql += "'" + productFirms[i] + "'" + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")\n";
        }
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                String utilities = rs.getString("utilities");
                int categoryId = rs.getInt("categoryId");
                String type = rs.getString("type");
                String firm = rs.getString("firm");

                Product p = null;
                if (cateid == 1) {
                    ElectricStove e = new ElectricStove(type);
                    p = new Product(id, name, img, price, discount, categoryId, utilities, firm, e);
                } else if (cateid == 2) {
                    ExtractorHood e = new ExtractorHood(type);
                    p = new Product(id, name, img, price, discount, categoryId, utilities, firm, e);
                } else if (cateid == 3) {
                    Blender e = new Blender(type);
                    p = new Product(id, name, img, price, discount, categoryId, utilities, firm, e);
                } else if (cateid == 4) {
                    Microwave e = new Microwave(type);
                    p = new Product(id, name, img, price, discount, categoryId, utilities, firm, e);
                } else if (cateid == 5) {
                    Refrigerator e = new Refrigerator(type);
                    p = new Product(id, name, img, price, discount, categoryId, utilities, firm, e);
                } else if (cateid == 6) {
                    WaterPurifier e = new WaterPurifier(type);
                    p = new Product(id, name, img, price, discount, categoryId, utilities, firm, e);
                }
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all details electricStoves
    public List<Product> detailStove(Integer pid, Integer cateId) {
        String sql = "select *\n"
                + "from Product as p\n"
                + "join Electricstove as e\n"
                + "on p.id = e.productId\n"
                + "where 1 =1\n";
        List<Product> list = new ArrayList<>();

        if (pid != null && cateId != null) {
            sql += "and p.id = " + pid + "\n"
                    + "and p.categoryId = " + cateId + "";
        }
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int date = rs.getInt("date_release");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String power = rs.getString("power");
                String utilities = rs.getString("utilities");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String warranty = rs.getString("warranty");
                String trademark = rs.getString("trademark");
                String firm = rs.getString("firm");
                String type = rs.getString("type");
                String surface_material = rs.getString("surface_material");
                String control_panel = rs.getString("control_panel");
                String cooker_type = rs.getString("cooker_type");
                String safety_features = rs.getString("safety_features");

                ElectricStove e = new ElectricStove(id, type, surface_material, control_panel, cooker_type, safety_features);
                Product p = new Product(id, name, img, price, discount, date, quantity, categoryId, power, utilities, size, weight, warranty, trademark, firm, e);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all details Extractor Hood
    public List<Product> detailExtractor(Integer pid, Integer cateId) {
        String sql = "select *\n"
                + "from Product as p\n"
                + "join Extractorhood as e\n"
                + "on p.id = e.productId\n"
                + "where 1 =1";
        List<Product> list = new ArrayList<>();
        if (pid != null && cateId != null) {
            sql += "and p.id = " + pid + "\n"
                    + "and p.categoryId = " + cateId + "";
        }
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int date = rs.getInt("date_release");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String power = rs.getString("power");
                String utilities = rs.getString("utilities");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String warranty = rs.getString("warranty");
                String trademark = rs.getString("trademark");
                String firm = rs.getString("firm");
                String type = rs.getString("type");
                String control = rs.getString("control");
                String max_noise = rs.getString("max_noise");
                String mesh_material = rs.getString("mesh_material");
                String lighting = rs.getString("lighting");
                String air_outlet_diameter = rs.getString("air_outlet_pipe_diameter");

                ExtractorHood e = new ExtractorHood(id, type, control, max_noise, mesh_material, lighting, air_outlet_diameter);
                Product p = new Product(id, name, img, price, discount, date, quantity, categoryId, power, utilities, size, weight, warranty, trademark, firm, e);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all details Blender
    public List<Product> detailBlender(Integer pid, Integer cateId) {
        String sql = "select *\n"
                + "from Product as p\n"
                + "join Blender as e\n"
                + "on p.id = e.productId\n"
                + "where 1 =1";
        List<Product> list = new ArrayList<>();
        if (pid != null && cateId != null) {
            sql += "and p.id = " + pid + "\n"
                    + "and p.categoryId = " + cateId + "";
        }
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int date = rs.getInt("date_release");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String power = rs.getString("power");
                String utilities = rs.getString("utilities");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String warranty = rs.getString("warranty");
                String trademark = rs.getString("trademark");
                String firm = rs.getString("firm");
                String type = rs.getString("type");
                String main_function = rs.getString("main_function");
                String mill = rs.getString("mill");
                String main_mortal_material = rs.getString("main_mortal_material");
                String blades = rs.getString("blades");
                String speed = rs.getString("speed");
                String safety_features = rs.getString("safety_features");

                Blender e = new Blender(id, type, main_function, mill, main_mortal_material, blades, speed, safety_features);
                Product p = new Product(id, name, img, price, discount, date, quantity, categoryId, power, utilities, size, weight, warranty, trademark, firm, e);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all details Microwave
    public List<Product> detailMicrowave(Integer pid, Integer cateId) {
        String sql = "select *\n"
                + "from Product as p\n"
                + "join Microwave as e\n"
                + "on p.id = e.productId\n"
                + "where 1 =1";
        List<Product> list = new ArrayList<>();
        if (pid != null && cateId != null) {
            sql += "and p.id = " + pid + "\n"
                    + "and p.categoryId = " + cateId + "";
        }
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int date = rs.getInt("date_release");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String power = rs.getString("power");
                String utilities = rs.getString("utilities");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String warranty = rs.getString("warranty");
                String trademark = rs.getString("trademark");
                String firm = rs.getString("firm");
                String type = rs.getString("type");
                String volume = rs.getString("volume");
                String furnace_cavity_material = rs.getString("furnace_cavity_material");
                String main_function = rs.getString("main_function");
                String control = rs.getString("control");

                Microwave e = new Microwave(id, type, volume, furnace_cavity_material, main_function, control);
                Product p = new Product(id, name, img, price, discount, date, quantity, categoryId, power, utilities, size, weight, warranty, trademark, firm, e);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all details Microwave
    public List<Product> detailRefrigerator(Integer pid, Integer cateId) {
        String sql = "select *\n"
                + "from Product as p\n"
                + "join Refrigerator as e\n"
                + "on p.id = e.productId\n"
                + "where 1 =1";
        List<Product> list = new ArrayList<>();
        if (pid != null && cateId != null) {
            sql += "and p.id = " + pid + "\n"
                    + "and p.categoryId = " + cateId + "";
        }
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int date = rs.getInt("date_release");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String power = rs.getString("power");
                String utilities = rs.getString("utilities");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String warranty = rs.getString("warranty");
                String trademark = rs.getString("trademark");
                String firm = rs.getString("firm");
                String type = rs.getString("type");
                String capacity = rs.getString("capacity");
                String energy_saving_technology = rs.getString("energy_saving_technology");
                String refrigeration_technology = rs.getString("refrigeration_technology");
                String antimicrobial_deodorizing_technology = rs.getString("antimicrobial_deodorizing_technology");
                String food_preservation_technology = rs.getString("food_preservation_technology");

                Refrigerator e = new Refrigerator(id, type, capacity, capacity, weight, antimicrobial_deodorizing_technology, food_preservation_technology);
                Product p = new Product(id, name, img, price, discount, date, quantity, categoryId, power, utilities, size, weight, warranty, trademark, firm, e);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all details water purifier
    public List<Product> detailWaterPurifier(Integer pid, Integer cateId) {
        String sql = "select *\n"
                + "from Product as p\n"
                + "join WaterPurifier as e\n"
                + "on p.id = e.productId\n"
                + "where 1 =1";
        List<Product> list = new ArrayList<>();
        if (pid != null && cateId != null) {
            sql += "and p.id = " + pid + "\n"
                    + "and p.categoryId = " + cateId + "";
        }
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int date = rs.getInt("date_release");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String power = rs.getString("power");
                String utilities = rs.getString("utilities");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String warranty = rs.getString("warranty");
                String trademark = rs.getString("trademark");
                String firm = rs.getString("firm");
                String type = rs.getString("type");
                String num_filter = rs.getString("num_filter");
                String capacity = rs.getString("capacity");
                String filtration_discharge_ratio = rs.getString("filtration_discharge_ratio");

                WaterPurifier e = new WaterPurifier(id, type, num_filter, capacity, filtration_discharge_ratio);
                Product p = new Product(id, name, img, price, discount, date, quantity, categoryId, power, utilities, size, weight, warranty, trademark, firm, e);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Display related product
    public List<Product> displayRelatedProduct(int pid, int cateId) {
        String sql = "select * \n"
                + "from Product as p\n"
                + "where categoryId = " + cateId + "\n"
                + "and p.id != " + pid + "";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                float price = rs.getFloat("price");
                int discount = rs.getInt("discount");
                int categoryId = rs.getInt("categoryId");
                Product p = new Product(id, name, img, price, discount, categoryId);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Display type of product
    public List<String> displayType(String table, int cateId) {
        String sql = "select distinct type\n"
                + "from Product as p\n"
                + "join " + table + " as e\n"
                + "on p.id = e.productId";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String type = rs.getString("type");
                list.add(type);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // Display firm of product
    public List<String> displayFirm(String table, int cateId) {
        String sql = "select distinct firm\n"
                + "from Product as p\n"
                + "join " + table + " as e\n"
                + "on p.id = e.productId";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String firm = rs.getString("firm");
                list.add(firm);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //Insert comment
    public void insertComment(int pid, int uid, String comment, String vote) {
        String sql = "Insert into Comment(pId, uId, comment, vote)\n"
                + "values(?,?,?,?)";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, uid);
            ps.setString(3, comment);
            ps.setString(4, vote);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Paging
    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    // get number commnet about product
    public int numComment(int pid) {
        String sql = "select count(*) as 'numComment' \n"
                + "from Comment\n"
                + "where pId = " + pid;
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt("numComment");
                return num;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    // display comment about product
    public List<Comment> displayComment(int pid) {
        List<Comment> list = new ArrayList<>();
        String sql = "select c.comment, c.date as 'datecomment', c.uId, u.name, u.avatar\n"
                + "from Comment as C\n"
                + "join [User] as u\n"
                + "on c.uId = u.userId\n"
                + "where pId = " + pid;
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String comment = rs.getString("comment");
                Date date = rs.getDate("datecomment");
                int uid = rs.getInt("uId");
                String name = rs.getString("name");
                String avatar = rs.getString("avatar");
                list.add(new Comment(new User(uid, name, avatar), comment, date));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // delete a product
    public void deleteProduct(int pid, int cid) {

        if (cid == 1) {
            //delete ElectricStove
            String sql1 = "delete from ElectricStove\n"
                    + "where productId = " + pid;
            try {
                PreparedStatement ps = Connection.prepareStatement(sql1);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 2) {
            //delete ElectricStove
            String sql2 = "delete from ExtractorHood\n"
                    + "where productId = " + pid;
            try {
                PreparedStatement ps = Connection.prepareStatement(sql2);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 3) {
            //delete ElectricStove
            String sql3 = "delete from Blender\n"
                    + "where productId = " + pid;
            try {
                PreparedStatement ps = Connection.prepareStatement(sql3);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 4) {
            //delete ElectricStove
            String sql4 = "delete from Microwave\n"
                    + "where productId = " + pid;
            try {
                PreparedStatement ps = Connection.prepareStatement(sql4);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 5) {
            //delete ElectricStove
            String sql5 = "delete from Refrigerator\n"
                    + "where productId = " + pid;
            try {
                PreparedStatement ps = Connection.prepareStatement(sql5);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 6) {
            //delete ElectricStove
            String sql6 = "delete from WaterPurifier\n"
                    + "where productId = " + pid;
            try {
                PreparedStatement ps = Connection.prepareStatement(sql6);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        //delete Product
        String sql = "delete from Product\n"
                + "where id = " + pid;
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update a product
    public void updateProduct(int pid, int cid, Product p) {

        //update Product
        String sql = "update Product\n"
                + "set name = ?,\n"
                + "img = ?,\n"
                + "price = ?,\n"
                + "discount = ?,\n"
                + "date_release = ?,\n"
                + "quantity = ?,\n"
                + "categoryId = ?,\n"
                + "power = ?,\n"
                + "utilities = ?,\n"
                + "size = ?,\n"
                + "weight = ?,\n"
                + "warranty = ?,\n"
                + "trademark = ?,\n"
                + "firm = ?\n"
                + "where id = ?";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getImg());
            ps.setFloat(3, p.getPrice());
            ps.setInt(4, p.getDiscount());
            ps.setInt(5, p.getDateRelease());
            ps.setInt(6, p.getQuantity());
            ps.setInt(7, p.getCategoryId());
            ps.setString(8, p.getPower());
            ps.setString(9, p.getUtilities());
            ps.setString(10, p.getSize());
            ps.setString(11, p.getWeight());
            ps.setString(12, p.getWarranty());
            ps.setString(13, p.getTrademark());
            ps.setString(14, p.getFirm());
            ps.setInt(15, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (cid == 1) {
            //delete ElectricStove
            String sql1 = "update ElectricStove\n"
                    + "set type = ?,\n"
                    + "surface_material = ?,\n"
                    + "control_panel = ?,\n"
                    + "cooker_type = ?,\n"
                    + "safety_features = ?\n"
                    + "where productId = ?";
            try {
                ElectricStove e = (ElectricStove) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql1);
                ps.setString(1, e.getType());
                ps.setString(2, e.getSurfaceMaterial());
                ps.setString(3, e.getControlPanel());
                ps.setString(4, e.getCookerType());
                ps.setString(5, e.getSafetyFeatures());
                ps.setInt(6, p.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 2) {
            //delete ElectricStove
            String sql2 = "update ExtractorHood\n"
                    + "set type = ?,\n"
                    + "control = ?,\n"
                    + "max_noise = ?,\n"
                    + "mesh_material = ?,\n"
                    + "lighting = ?,\n"
                    + "air_outlet_pipe_diameter = ?\n"
                    + "where productId = ?";
            try {
                ExtractorHood e = (ExtractorHood) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql2);
                ps.setString(1, e.getType());
                ps.setString(2, e.getControl());
                ps.setString(3, e.getMaxNoise());
                ps.setString(4, e.getMeshMaterial());
                ps.setString(5, e.getLighting());
                ps.setString(6, e.getAirOutletPipeDiameter());
                ps.setInt(7, p.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 3) {
            //delete ElectricStove
            String sql3 = "update Blender\n"
                    + "set type = ?,\n"
                    + "main_function = ?,\n"
                    + "mill = ?,\n"
                    + "main_mortal_material = ?,\n"
                    + "blades = ?,\n"
                    + "speed = ?,\n"
                    + "safety_features = ?\n"
                    + "where productId = ?";
            try {
                Blender e = (Blender) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql3);
                ps.setString(1, e.getType());
                ps.setString(2, e.getMainFunction());
                ps.setString(3, e.getMill());
                ps.setString(4, e.getMortalMaterial());
                ps.setString(5, e.getBlades());
                ps.setString(6, e.getSpeed());
                ps.setString(7, e.getSafetyFeatures());
                ps.setInt(8, p.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 4) {
            //delete ElectricStove
            String sql4 = "update Microwave\n"
                    + "set type = ?,\n"
                    + "volume = ?,\n"
                    + "furnace_cavity_material = ?,\n"
                    + "main_function = ?,\n"
                    + "control = ?\n"
                    + "where productId = ?";
            try {
                Microwave e = (Microwave) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql4);
                ps.setString(1, e.getType());
                ps.setString(2, e.getVolume());
                ps.setString(3, e.getFurnaceCavityMaterial());
                ps.setString(4, e.getMainFunction());
                ps.setString(5, e.getControl());
                ps.setInt(6, p.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 5) {
            //delete ElectricStove
            String sql5 = "update Refrigerator\n"
                    + "set type = ?,\n"
                    + "capacity = ?,\n"
                    + "energy_saving_technology = ?,\n"
                    + "refrigeration_technology = ?,\n"
                    + "antimicrobial_deodorizing_technology = ?,\n"
                    + "food_preservation_technology = ?\n"
                    + "where productId = ?";
            try {
                Refrigerator e = (Refrigerator) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql5);
                ps.setString(1, e.getType());
                ps.setString(2, e.getCapacity());
                ps.setString(3, e.getEnergySaving());
                ps.setString(4, e.getRefrigeration());
                ps.setString(5, e.getAntimicrobialDeodorozing());
                ps.setString(6, e.getFoodPreservation());
                ps.setInt(7, p.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 6) {
            //delete ElectricStove
            String sql6 = "update WaterPurifier\n"
                    + "set type = ?,\n"
                    + "num_filter = ?,\n"
                    + "capacity = ?,\n"
                    + "filtration_discharge_ratio = ?\n"
                    + "where productId = ?";
            try {
                WaterPurifier e = (WaterPurifier) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql6);
                ps.setString(1, e.getType());
                ps.setString(2, e.getNumFilter());
                ps.setString(3, e.getCapacity());
                ps.setString(4, e.getFiltrationDischargeRatio());
                ps.setInt(5, p.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    // get latest product id
    public Integer productId() {
        String sql = "select top(1)id \n"
                + "from Product\n"
                + "order by id desc";
        Integer id = null;
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
        }
        return id;
    }

    // add a product
    public void addProduct(int cid, Product p) {

        //update Product
        String sql = "insert into Product([name], img, price, discount, date_release, quantity, categoryId, [power], utilities, size, [weight], warranty, trademark, firm)\n"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getImg());
            ps.setFloat(3, p.getPrice());
            ps.setInt(4, p.getDiscount());
            ps.setInt(5, p.getDateRelease());
            ps.setInt(6, p.getQuantity());
            ps.setInt(7, p.getCategoryId());
            ps.setString(8, p.getPower());
            ps.setString(9, p.getUtilities());
            ps.setString(10, p.getSize());
            ps.setString(11, p.getWeight());
            ps.setString(12, p.getWarranty());
            ps.setString(13, p.getTrademark());
            ps.setString(14, p.getFirm());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        int pid = productId();

        if (cid == 1) {
            //delete ElectricStove
            String sql1 = "insert into ElectricStove(productId, [type], surface_material, control_panel, cooker_type, safety_features)\n"
                    + "values(?,?,?,?,?,?)";
            try {
                ElectricStove e = (ElectricStove) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql1);
                ps.setInt(1, pid);
                ps.setString(2, e.getType());
                ps.setString(3, e.getSurfaceMaterial());
                ps.setString(4, e.getControlPanel());
                ps.setString(5, e.getCookerType());
                ps.setString(6, e.getSafetyFeatures());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 2) {
            //delete ElectricStove
            String sql2 = "insert into ExtractorHood(productId, [type], [control], max_noise, mesh_material, lighting, air_outlet_pipe_diameter)\n"
                    + "values(?,?,?,?,?,?,?)";
            try {
                ExtractorHood e = (ExtractorHood) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql2);
                ps.setInt(1, pid);
                ps.setString(2, e.getType());
                ps.setString(3, e.getControl());
                ps.setString(4, e.getMaxNoise());
                ps.setString(5, e.getMeshMaterial());
                ps.setString(6, e.getLighting());
                ps.setString(7, e.getAirOutletPipeDiameter());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 3) {
            //delete ElectricStove
            String sql3 = "insert into Blender(productId, [type], main_function, mill, main_mortal_material, blades, speed, safety_features)\n"
                    + "values(?,?,?,?,?,?,?,?)";
            try {
                Blender e = (Blender) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql3);
                ps.setInt(1, pid);
                ps.setString(2, e.getType());
                ps.setString(3, e.getMainFunction());
                ps.setString(4, e.getMill());
                ps.setString(5, e.getMortalMaterial());
                ps.setString(6, e.getBlades());
                ps.setString(7, e.getSpeed());
                ps.setString(8, e.getSafetyFeatures());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 4) {
            //delete ElectricStove
            String sql4 = "insert into Microwave(productId, [type], volume, furnace_cavity_material, main_function, [control])\n"
                    + "values(?,?,?,?,?,?)";
            try {
                Microwave e = (Microwave) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql4);
                ps.setInt(1, pid);
                ps.setString(2, e.getType());
                ps.setString(3, e.getVolume());
                ps.setString(4, e.getFurnaceCavityMaterial());
                ps.setString(5, e.getMainFunction());
                ps.setString(6, e.getControl());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 5) {
            //delete ElectricStove
            String sql5 = "insert into Refrigerator(productId, [type], capacity, energy_saving_technology, refrigeration_technology, antimicrobial_deodorizing_technology, food_preservation_technology)\n"
                    + "values(?,?,?,?,?,?,?)";
            try {
                Refrigerator e = (Refrigerator) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql5);
                ps.setInt(1, pid);
                ps.setString(2, e.getType());
                ps.setString(3, e.getCapacity());
                ps.setString(4, e.getEnergySaving());
                ps.setString(5, e.getRefrigeration());
                ps.setString(6, e.getAntimicrobialDeodorozing());
                ps.setString(7, e.getFoodPreservation());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else if (cid == 6) {
            //delete ElectricStove
            String sql6 = "insert into WaterPurifier(productId, [type], num_filter, capacity, filtration_discharge_ratio)\n"
                    + "values(?,?,?,?,?)";
            try {
                WaterPurifier e = (WaterPurifier) p.getT();
                PreparedStatement ps = Connection.prepareStatement(sql6);
                ps.setInt(1, pid);
                ps.setString(2, e.getType());
                ps.setString(3, e.getNumFilter());
                ps.setString(4, e.getCapacity());
                ps.setString(5, e.getFiltrationDischargeRatio());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    // insert Order and Order details
    public void order(Cart c, User u) {
        String sql1 = "insert into [Order](userId, totalMoney)\n"
                + "values(?,?)";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql1);
            ps.setInt(1, u.getUserId());
            ps.setFloat(2, c.getTotalMoney());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        String sql2 = "select top 1 orderId\n"
                + "from [Order]\n"
                + "order by orderId desc";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item i : c.getItems()) {
                    String sql3 = "insert into OrderDetails\n"
                            + "values(?,?,?,?)";
                    try {
                        PreparedStatement ps2 = Connection.prepareStatement(sql3);
                        ps2.setInt(1, oid);
                        ps2.setInt(2, i.getProduct().getId());
                        ps2.setInt(3, i.getQuantity());
                        ps2.setFloat(4, (float) i.getPrice());
                        ps2.executeUpdate();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // select cate by id
    public Integer cateId(int pid) {
        String sql = "select categoryId\n"
                + "from Product\n"
                + "where id = ?";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int cid = rs.getInt("categoryId");
                return cid;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //Order List
    public List<Order> orderList() {
        List<Order> list = new ArrayList<>();
        String sql = "select o.orderId, o.userId, u.name as 'username', u.address, o.orderDate, od.productId, p.name, od.quantity, o.totalMoney\n"
                + "from [Order] as o\n"
                + "join OrderDetails as od on o.orderId = od.orderId\n"
                + "join [User] as u on o.userId = u.userId\n"
                + "join Product as p on od.productId = p.id";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int oid = rs.getInt("orderId");
                int uid = rs.getInt("userId");
                String username = rs.getString("username");
                String address = rs.getString("address");
                String orderDate = rs.getString("orderDate");
                float total = rs.getFloat("totalMoney");
                list.add(new Order(oid, new User(uid, username, address), orderDate, total));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Map<String, Integer> chart1() {
        Map<String, Integer> sellCate = new HashMap<>();
        String sql = "select p.categoryId, c.categoryName , sum(od.quantity) as 'NumSell'\n"
                + "from [Order] as o\n"
                + "join OrderDetails as od on o.orderId = od.orderId\n"
                + "join Product as p on od.productId = p.id\n"
                + "join Category as c on p.categoryId = c.categoryId\n"
                + "group by p.categoryId, c.categoryName";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cateName = rs.getString("categoryName");
                int numSell = rs.getInt("NumSell");
                sellCate.put(cateName, numSell);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sellCate;
    }

    // top 5 seller product
    public Map<String, Integer> fiveSellest() {
        Map<String, Integer> topSeller = new HashMap<>();
        String sql = "select top 5 p.id, p.name , sum(od.quantity) as 'NumSell'\n"
                + "from [Order] as o\n"
                + "join OrderDetails as od on o.orderId = od.orderId\n"
                + "join Product as p on od.productId = p.id\n"
                + "group by p.id, p.name\n"
                + "order by NumSell desc";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int quantity = rs.getInt("NumSell");
                topSeller.put(name, quantity);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return topSeller;
    }

    // count number comment
    public Integer numComment() {
        String sql = "select count(comment) as 'numComment' \n"
                + "from Comment";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt("numComment");
                return num;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // count number user register
    public Integer numUser() {
        String sql = "select count(userId) as 'numUser'\n"
                + "from [User]";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt("numUser");
                return num;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // count number user register
    public Integer numOrder() {
        String sql = "select count(orderId) as 'numOrder'\n"
                + "from [Order]";
        try {
            PreparedStatement ps = Connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt("numOrder");
                return num;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertPayment(int productID, int userID) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([productID]\n"
                + "           ,[userID])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement st = Connection.prepareStatement(sql);
            st.setInt(1, productID);
            st.setInt(2, userID);
            st.executeUpdate();
        } catch (SQLException e) {
        }

    }

    public void inserVN_PAY(String trans, int user_ID, String productID) {
        String sql = "INSERT INTO [dbo].[Vn_Pay]\n"
                + "     VALUES\n"
                + "           (" + user_ID + "," + productID + "," + "?)";
        try {
            PreparedStatement st = Connection.prepareStatement(sql);
            st.setString(1, trans);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Vn_Pay getVN_Pay(String magd) {
        String sql = "select * from Vn_Pay where Vn_gd = '" + magd + "'";
        try {
            PreparedStatement st = Connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Vn_Pay v = new Vn_Pay(rs.getInt(1), rs.getInt(2), rs.getString(3));
                return v;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Integer getCateByProduct(int pid) {
        String sql = "select categoryId \n"
                + "from Product\n"
                + "where id = "+ pid;
        try {
            PreparedStatement st = Connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int cateid = rs.getInt(1);
                return cateid;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
