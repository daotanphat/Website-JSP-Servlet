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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Comment;
import model.Item;
import model.Product;

/**
 *
 * @author Asus
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/cart"})
public class AddToCart extends HttpServlet {

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
            out.println("<title>Servlet AddToCart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCart at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");

        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        String numCart = request.getParameter("numBuy");
        String tid = request.getParameter("pid");
        String cateId = request.getParameter("cateId");
        int num, pid = 0, catedId = 0;
        try {
            num = Integer.parseInt(numCart);
            pid = Integer.parseInt(tid);
            catedId = Integer.parseInt(cateId);

            Product p = dao.getProductById(pid);
            float price = p.getPrice() - (p.getPrice() * ((float)p.getDiscount()/100));
            Item t = new Item(p, num, price);
            cart.addItem(t);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        List<Item> items = cart.getItems();
        session.setAttribute("cart", cart);
        session.setAttribute("size", items.size());

        List<Product> list = new ArrayList<>();
        List<Product> relatedProduct = new ArrayList<>();
        List<Comment> listComment;

        listComment = dao.displayComment(pid);
        int numComment = dao.numComment(pid);

        if (catedId == 1) {
            list = dao.detailStove(pid, catedId);
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
