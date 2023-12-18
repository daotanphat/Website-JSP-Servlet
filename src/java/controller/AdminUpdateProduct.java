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
@WebServlet(name = "AdminUpdateProduct", urlPatterns = {"/update_product"})
@MultipartConfig
public class AdminUpdateProduct extends HttpServlet {

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
            out.println("<title>Servlet AdminUpdateProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminUpdateProduct at " + request.getContextPath() + "</h1>");
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
        String pid_raw = request.getParameter("pid");
        String name = request.getParameter("name");

//        Part a = request.getPart("fileInput");
//        String realPath = request.getServletContext().getRealPath("./assets/img");
//        String img = "./assets/img/Product/" + Paths.get(a.getSubmittedFileName()).getFileName().toString();
        String img = "./assets/img/";
//        if (!Files.exists(Paths.get(realPath))) {
//            Files.createDirectories(Paths.get(realPath));
//        }

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

        int pid;
        float price;
        int discount;
        int date;
        int quantity;
        int catedId;
        DAO dao = new DAO();
        List<Product> list = new ArrayList<>();
        try {
            pid = Integer.parseInt(pid_raw);
            price = Float.parseFloat(price_raw);
            discount = Integer.parseInt(discount_raw);
            date = Integer.parseInt(date_raw);
            quantity = Integer.parseInt(quantity_raw);
            catedId = Integer.parseInt(cateid_raw);

            if (catedId == 1) {
                String type = request.getParameter("type1");
                String surface = request.getParameter("surface");
                String control = request.getParameter("control1");
                String cooker = request.getParameter("cooker");
                String safety = request.getParameter("safety1");
                ElectricStove e = new ElectricStove(pid, type, surface, control, cooker, safety);
                Product p = new Product(pid, name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);

                dao.updateProduct(pid, catedId, p);
                list = dao.detailStove(pid, catedId);
            } else if (catedId == 2) {
                String type = request.getParameter("type2");
                String control = request.getParameter("control2");
                String noise = request.getParameter("noise");
                String mesh = request.getParameter("mesh");
                String lighting = request.getParameter("lighting");
                String outlet = request.getParameter("outlet");
                ExtractorHood e = new ExtractorHood(pid, type, control, noise, mesh, lighting, outlet);
                Product p = new Product(pid, name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);

                dao.updateProduct(pid, catedId, p);
                list = dao.detailExtractor(pid, catedId);
            } else if (catedId == 3) {
                String type = request.getParameter("type3");
                String function = request.getParameter("function3");
                String mill = request.getParameter("mill");
                String mortal = request.getParameter("mortal");
                String blades = request.getParameter("blades");
                String speed = request.getParameter("speed");
                String safety = request.getParameter("safety3");
                Blender e = new Blender(pid, type, function, mill, mortal, blades, speed, safety);
                Product p = new Product(pid, name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);

                dao.updateProduct(pid, catedId, p);
                list = dao.detailBlender(pid, catedId);
            } else if (catedId == 4) {
                String type = request.getParameter("type4");
                String volume = request.getParameter("volume");
                String furnace = request.getParameter("furnace");
                String function = request.getParameter("function4");
                String control = request.getParameter("control4");
                Microwave e = new Microwave(pid, type, volume, furnace, function, control);
                Product p = new Product(pid, name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);

                dao.updateProduct(pid, catedId, p);
                list = dao.detailMicrowave(pid, catedId);
            } else if (catedId == 5) {
                String type = request.getParameter("type5");
                String capacity = request.getParameter("capacity5");
                String energy = request.getParameter("energy");
                String refrigeration = request.getParameter("refrigeration");
                String antimicrobial = request.getParameter("antimicrobial");
                String food = request.getParameter("food");
                Refrigerator e = new Refrigerator(pid, type, capacity, energy, refrigeration, antimicrobial, refrigeration);
                Product p = new Product(pid, name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);

                dao.updateProduct(pid, catedId, p);
                list = dao.detailRefrigerator(pid, catedId);
            } else if (catedId == 6) {
                String type = request.getParameter("type6");
                String numfilter = request.getParameter("numfilter");
                String capacity = request.getParameter("capacity6");
                String filtration = request.getParameter("filtration");
                WaterPurifier e = new WaterPurifier(pid, type, numfilter, capacity, filtration);
                Product p = new Product(pid, name, img, price, discount, date, quantity, catedId, power, utilities, size, weight, warranty, trademark, firm, e);

                dao.updateProduct(pid, catedId, p);
                list = dao.detailWaterPurifier(pid, catedId);
            }
            request.setAttribute("detailProduct", list.get(0));
            request.getRequestDispatcher("admin_edit-product.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
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
        processRequest(request, response);
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
