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
import model.Comment;
import model.Product;
import model.User;

/**
 *
 * @author Asus
 */
@WebServlet(name = "DetailProduct", urlPatterns = {"/detail-product"})
public class DetailProduct extends HttpServlet {

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
            out.println("<title>Servlet DetailProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailProduct at " + request.getContextPath() + "</h1>");
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
        String cateId_raw = request.getParameter("cateId");

        int pid, catedId;
        try {
            pid = Integer.parseInt(pid_raw);
            catedId = Integer.parseInt(cateId_raw);

            List<Product> list = new ArrayList<>();
            List<Product> relatedProduct = new ArrayList<>();
            List<Comment> listComment = new ArrayList<>();

            listComment = dao.displayComment(pid);
            int numComment = dao.numComment(pid);
            
            if (catedId == 1) {
                list = dao.detailStove(pid, catedId);
                System.out.println(list.get(0).getName());
                relatedProduct = dao.displayRelatedProduct(pid, catedId);
            } else if (catedId == 2) {
                list = dao.detailExtractor(pid, catedId);
                relatedProduct = dao.displayRelatedProduct(pid, catedId);
            } else if (catedId == 3) {
                list = dao.detailBlender(pid, catedId);
                relatedProduct = dao.displayRelatedProduct(pid, catedId);
            } else if (catedId == 4) {
                list = dao.detailMicrowave(pid, catedId);
                relatedProduct = dao.displayRelatedProduct(pid, catedId);
            } else if (catedId == 5) {
                list = dao.detailRefrigerator(pid, catedId);
                relatedProduct = dao.displayRelatedProduct(pid, catedId);
            } else if (catedId == 6) {
                list = dao.detailWaterPurifier(pid, catedId);
                relatedProduct = dao.displayRelatedProduct(pid, catedId);
            }
            request.setAttribute("product", list.get(0));
            request.setAttribute("relatedProduct", relatedProduct);
            request.setAttribute("listComment", listComment);
            request.setAttribute("numComment", numComment);
            request.getRequestDispatcher("Product.jsp").forward(request, response);
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
