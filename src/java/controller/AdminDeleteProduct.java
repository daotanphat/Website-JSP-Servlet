/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Asus
 */
@WebServlet(name = "AdminDeleteProduct", urlPatterns = {"/delete_product"})
public class AdminDeleteProduct extends HttpServlet {

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
            out.println("<title>Servlet AdminDeleteProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminDeleteProduct at " + request.getContextPath() + "</h1>");
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
        String pid_raw = request.getParameter("pid");
        String cid_raw = request.getParameter("cid");
        int pid, cid;
        try {
            pid = Integer.parseInt(pid_raw);
            cid = Integer.parseInt(cid_raw);
            dao.deleteProduct(pid, cid);
            List<Product> list = new ArrayList<>();
            List<Category> listCate = new ArrayList<>();
            list = dao.displayAllProduct();
            listCate = dao.getAll();
            request.setAttribute("allProducts", list);
            request.setAttribute("Categories", listCate);
            request.getRequestDispatcher("admin_products.jsp").forward(request, response);
        } catch (Exception e) {
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
        DAO dao = new DAO();
        
        String idProducts[] = request.getParameterValues("idProduct");
        
        int ids[] = new int[idProducts.length];
        int cids[] = new int[idProducts.length];
        try {
            for(int i = 0; i < idProducts.length; i++){
                ids[i] = Integer.parseInt(idProducts[i]);
                cids[i] = dao.cateId(ids[i]);
            }
            for(int i = 0; i < ids.length; i++){
                dao.deleteProduct(ids[i], cids[i]);
            }
            
            List<Product> list = new ArrayList<>();
            List<Category> listCate = new ArrayList<>();
            list = dao.displayAllProduct();
            listCate = dao.getAll();
            request.setAttribute("allProducts", list);
            request.setAttribute("Categories", listCate);
            request.getRequestDispatcher("admin_products.jsp").forward(request, response);
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
