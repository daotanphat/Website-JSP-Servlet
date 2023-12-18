/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Blender;
import model.Category;
import model.ElectricStove;
import model.ExtractorHood;
import model.Microwave;
import model.Product;
import model.Refrigerator;
import model.WaterPurifier;

/**
 *
 * @author Asus
 */
@WebServlet(name = "AdminAddProduct", urlPatterns = {"/add_product"})
@MultipartConfig
public class AdminAddProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        List<Category> listCate = new ArrayList<>();
        listCate = dao.getAll();
        request.setAttribute("Categories", listCate);
        request.getRequestDispatcher("admin_add-product.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        String name = request.getParameter("name");

//        Part a = request.getPart("fileInput");
//        String realPath = request.getServletContext().getRealPath("./assets/img");
//        String img = "./assets/img/Product/" + Paths.get(a.getSubmittedFileName()).getFileName().toString();
//        if (!Files.exists(Paths.get(realPath))) {
//            Files.createDirectories(Paths.get(realPath));
//        }
        String img = "./assets/img/";

        String price_raw = request.getParameter("price");
        String discount_raw = request.getParameter("discount");
        String date_raw = request.getParameter("date");
        String quantity_raw = request.getParameter("quantity");
        String cateid_raw = request.getParameter("cateid");
        String power = request.getParameter("power");
        String utilities = request.getParameter("utilities");
        String size = request.getParameter("size");
        String weight = request.getParameter("weight");
        String warranty = request.getParameter("warranty");
        String trademark = request.getParameter("trademark");
        String firm = request.getParameter("firm");

        float price;
        int discount;
        int date;
        int quantity;
        int catedId;
        try {
            price = Float.parseFloat(price_raw);
            discount = Integer.parseInt(discount_raw);
            date = Integer.parseInt(date_raw);
            quantity = Integer.parseInt(quantity_raw);
            catedId = Integer.parseInt(cateid_raw);

            if (catedId == 1) {
                String type1 = request.getParameter("type1");
                String surface = request.getParameter("surface");
                String control1 = request.getParameter("control1");
                String cooker = request.getParameter("cooker");
                String safety1 = request.getParameter("safety1");
                ElectricStove e = new ElectricStove(type1, surface, control1, cooker, safety1);
                Product p = new Product(name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);
                dao.addProduct(catedId, p);
            } else if (catedId == 2) {
                String type2 = request.getParameter("type2");
                String control2 = request.getParameter("control2");
                String noise = request.getParameter("noise");
                String mesh = request.getParameter("mesh");
                String lighting = request.getParameter("lighting");
                String outlet = request.getParameter("outlet");
                ExtractorHood e = new ExtractorHood(type2, control2, noise, mesh, lighting, outlet);
                Product p = new Product(name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);
                dao.addProduct(catedId, p);
            } else if (catedId == 3) {
                String type3 = request.getParameter("type3");
                String function3 = request.getParameter("function3");
                String mill = request.getParameter("mill");
                String mortal = request.getParameter("mortal");
                String blades = request.getParameter("blades");
                String speed = request.getParameter("speed");
                String safety3 = request.getParameter("safety3");
                Blender e = new Blender(type3, function3, mill, mortal, blades, speed, safety3);
                Product p = new Product(name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);
                dao.addProduct(catedId, p);
            } else if (catedId == 4) {
                String type4 = request.getParameter("type4");
                String volume = request.getParameter("volume");
                String furnace = request.getParameter("furnace");
                String function4 = request.getParameter("function4");
                String control4 = request.getParameter("control4");
                Microwave e = new Microwave(type4, volume, furnace, function4, control4);
                Product p = new Product(name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);
                dao.addProduct(catedId, p);
            } else if (catedId == 5) {
                String type5 = request.getParameter("type5");
                String capacity5 = request.getParameter("capacity5");
                String energy = request.getParameter("energy");
                String refrigeration = request.getParameter("refrigeration");
                String antimicrobial = request.getParameter("antimicrobial");
                String food = request.getParameter("food");
                Refrigerator e = new Refrigerator(type5, capacity5, energy, refrigeration, antimicrobial, refrigeration);
                Product p = new Product(name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);
                dao.addProduct(catedId, p);
            } else if (catedId == 6) {
                String type6 = request.getParameter("type6");
                String numfilter = request.getParameter("numfilter");
                String capacity6 = request.getParameter("capacity6");
                String filtration = request.getParameter("filtration");
                WaterPurifier e = new WaterPurifier(type6, numfilter, capacity6, filtration);
                Product p = new Product(name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);
                dao.addProduct(catedId, p);
            }
            request.getRequestDispatcher("admin_add-product.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
