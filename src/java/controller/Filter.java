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
@WebServlet(name = "Filter", urlPatterns = {"/filter"})
public class Filter extends HttpServlet {

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
            out.println("<title>Servlet Filter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Filter at " + request.getContextPath() + "</h1>");
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
        String categoryId_raw = request.getParameter("cId");
        String jsp_raw = request.getParameter("cName").replaceAll("\\s+", "");
        String jsp = jsp_raw + ".jsp";
        String xpage = request.getParameter("page");
        String key = request.getParameter("searchkey");
        
        String[] productTypes = request.getParameterValues("productType");
        String[] productFirms = request.getParameterValues("productFirm");
        
        boolean[] types;
        boolean[] firms;
        int categoryId, page;
        List<Product> list = new ArrayList<>();
        List<String> type = new ArrayList<>();
        List<String> firm = new ArrayList<>();

        try {
            categoryId = Integer.parseInt(categoryId_raw);
            type = dao.displayType(jsp_raw, categoryId);
            firm = dao.displayFirm(jsp_raw, categoryId);
            list = dao.filterProduct(jsp_raw, categoryId, productTypes, productFirms);
            types = new boolean[type.size()];
            firms = new boolean[firm.size()];
            for (int i = 0; i < types.length; i++) {
                if (isCheck(type.get(i), productTypes)) {
                    types[i] = true;
                } else {
                    types[i] = false;
                }
            }
            for (int i = 0; i < firms.length; i++) {
                if (isCheck(firm.get(i), productFirms)) {
                    firms[i] = true;
                } else {
                    firms[i] = false;
                }
            }

//            if (xpage == null) {
//                page = 1;
//            } else {
//                page = Integer.parseInt(xpage);
//            }
//            int numperpage = 6;
//            int size = list.size();
//            int numpage = (size % numperpage == 0) ? (size / numperpage) : (size / numperpage + 1);
//            int start = numperpage * (page - 1);
//            int end = Math.min(numperpage * page, size);
//            List<Product> listperpage = dao.getListByPage(list, start, end);
//
//            request.setAttribute("listProduct", listperpage);
//            request.setAttribute("page", page);
//            request.setAttribute("numpage", numpage);
            request.setAttribute("listProduct", list);
            request.setAttribute("cid", categoryId);
            request.setAttribute("cname", jsp_raw);
            request.setAttribute("type", type);
            request.setAttribute("firm", firm);
            request.setAttribute("search", key);
            request.setAttribute("types", types);
            request.setAttribute("firms", firms);
            request.setAttribute("productTypes", productTypes);
            request.setAttribute("productFirms", productFirms);
            request.setAttribute("urlpattern", "filter");
            request.getRequestDispatcher(jsp).forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    private boolean isCheck(String s, String[] products) {
        if (products == null) {
            return false;
        } else {
            for (int i = 0; i < products.length; i++) {
                if (products[i].equals(s)) {
                    return true;
                }
            }
            return false;
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
