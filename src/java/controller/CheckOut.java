/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.mail.Session;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Cart;
import model.Item;
import model.User;

/**
 *
 * @author Asus
 */
public class CheckOut extends HttpServlet {

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
            out.println("<title>Servlet CheckOut</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOut at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");

        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        request.setAttribute("total", cart.getTotalMoney());
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Cart c = (Cart) session.getAttribute("cart");
        User u = (User) session.getAttribute("user");

        DAO dao = new DAO();
        dao.order(c, u);
        session.removeAttribute("cart");
        session.removeAttribute("size");
        request.setAttribute("success", "Your order is sucessfully");

        final String username = "daotanphat2143@gmail.com";
        final String password = "dartksozrixrvgpl";

        // properties
        Properties pros = new Properties();
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.port", "587");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.enable", "true");

        // create authenticator
        Authenticator auth = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication(username, password);
            }

        };

        // phien lam viec
        Session sessionmail = Session.getInstance(pros, auth);

        // gui email
        final String to = u.getEmail();

        // tao 1 tin nhan
        MimeMessage msg = new MimeMessage(sessionmail);

        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(to);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject("Order Confirmation");

            // Set the content type to HTML
            String content = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\"\n"
                    + "	xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n"
                    + "\n"
                    + "<head>\n"
                    + "	<meta charset=\"utf-8\"> <!-- utf-8 works for most cases -->\n"
                    + "	<meta name=\"viewport\" content=\"width=device-width\"> <!-- Forcing initial-scale shouldn't be necessary -->\n"
                    + "	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <!-- Use the latest (edge) version of IE rendering engine -->\n"
                    + "	<meta name=\"x-apple-disable-message-reformatting\"> <!-- Disable auto-scale in iOS 10 Mail entirely -->\n"
                    + "	<title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->\n"
                    + "\n"
                    + "	<link href=\"https://fonts.googleapis.com/css?family=Work+Sans:200,300,400,500,600,700\" rel=\"stylesheet\">\n"
                    + "\n"
                    + "	<!-- CSS Reset : BEGIN -->\n"
                    + "	<style>\n"
                    + "		/* What it does: Remove spaces around the email design added by some email clients. */\n"
                    + "		/* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */\n"
                    + "		html,\n"
                    + "		body {\n"
                    + "			margin: 0 auto !important;\n"
                    + "			padding: 0 !important;\n"
                    + "			height: 100% !important;\n"
                    + "			width: 100% !important;\n"
                    + "			background: #f1f1f1;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Stops email clients resizing small text. */\n"
                    + "		* {\n"
                    + "			-ms-text-size-adjust: 100%;\n"
                    + "			-webkit-text-size-adjust: 100%;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Centers email on Android 4.4 */\n"
                    + "		div[style*=\"margin: 16px 0\"] {\n"
                    + "			margin: 0 !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Stops Outlook from adding extra spacing to tables. */\n"
                    + "		table,\n"
                    + "		td {\n"
                    + "			mso-table-lspace: 0pt !important;\n"
                    + "			mso-table-rspace: 0pt !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Fixes webkit padding issue. */\n"
                    + "		table {\n"
                    + "			border-spacing: 0 !important;\n"
                    + "			border-collapse: collapse !important;\n"
                    + "			table-layout: fixed !important;\n"
                    + "			margin: 0 auto !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Uses a better rendering method when resizing images in IE. */\n"
                    + "		img {\n"
                    + "			-ms-interpolation-mode: bicubic;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Prevents Windows 10 Mail from underlining links despite inline CSS. Styles for underlined links should be inline. */\n"
                    + "		a {\n"
                    + "			text-decoration: none;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: A work-around for email clients meddling in triggered links. */\n"
                    + "		*[x-apple-data-detectors],\n"
                    + "		/* iOS */\n"
                    + "		.unstyle-auto-detected-links *,\n"
                    + "		.aBn {\n"
                    + "			border-bottom: 0 !important;\n"
                    + "			cursor: default !important;\n"
                    + "			color: inherit !important;\n"
                    + "			text-decoration: none !important;\n"
                    + "			font-size: inherit !important;\n"
                    + "			font-family: inherit !important;\n"
                    + "			font-weight: inherit !important;\n"
                    + "			line-height: inherit !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Prevents Gmail from displaying a download button on large, non-linked images. */\n"
                    + "		.a6S {\n"
                    + "			display: none !important;\n"
                    + "			opacity: 0.01 !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Prevents Gmail from changing the text color in conversation threads. */\n"
                    + "		.im {\n"
                    + "			color: inherit !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* If the above doesn't work, add a .g-img class to any image in question. */\n"
                    + "		img.g-img+div {\n"
                    + "			display: none !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */\n"
                    + "		/* Create one of these media queries for each additional viewport size you'd like to fix */\n"
                    + "\n"
                    + "		/* iPhone 4, 4S, 5, 5S, 5C, and 5SE */\n"
                    + "		@media only screen and (min-device-width: 320px) and (max-device-width: 374px) {\n"
                    + "			u~div .email-container {\n"
                    + "				min-width: 320px !important;\n"
                    + "			}\n"
                    + "		}\n"
                    + "\n"
                    + "		/* iPhone 6, 6S, 7, 8, and X */\n"
                    + "		@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {\n"
                    + "			u~div .email-container {\n"
                    + "				min-width: 375px !important;\n"
                    + "			}\n"
                    + "		}\n"
                    + "\n"
                    + "		/* iPhone 6+, 7+, and 8+ */\n"
                    + "		@media only screen and (min-device-width: 414px) {\n"
                    + "			u~div .email-container {\n"
                    + "				min-width: 414px !important;\n"
                    + "			}\n"
                    + "		}\n"
                    + "	</style>\n"
                    + "\n"
                    + "	<!-- CSS Reset : END -->\n"
                    + "\n"
                    + "	<!-- Progressive Enhancements : BEGIN -->\n"
                    + "	<style>\n"
                    + "		.primary {\n"
                    + "			background: #17bebb;\n"
                    + "		}\n"
                    + "\n"
                    + "		.bg_white {\n"
                    + "			background: #ffffff;\n"
                    + "		}\n"
                    + "\n"
                    + "		.bg_light {\n"
                    + "			background: #f7fafa;\n"
                    + "		}\n"
                    + "\n"
                    + "		.bg_black {\n"
                    + "			background: #000000;\n"
                    + "		}\n"
                    + "\n"
                    + "		.bg_dark {\n"
                    + "			background: rgba(0, 0, 0, .8);\n"
                    + "		}\n"
                    + "\n"
                    + "		.email-section {\n"
                    + "			padding: 2.5em;\n"
                    + "		}\n"
                    + "\n"
                    + "		/*BUTTON*/\n"
                    + "		.btn {\n"
                    + "			padding: 10px 15px;\n"
                    + "			display: inline-block;\n"
                    + "		}\n"
                    + "\n"
                    + "		.btn.btn-primary {\n"
                    + "			border-radius: 5px;\n"
                    + "			background: #17bebb;\n"
                    + "			color: #ffffff;\n"
                    + "		}\n"
                    + "\n"
                    + "		.btn.btn-white {\n"
                    + "			border-radius: 5px;\n"
                    + "			background: #ffffff;\n"
                    + "			color: #000000;\n"
                    + "		}\n"
                    + "\n"
                    + "		.btn.btn-white-outline {\n"
                    + "			border-radius: 5px;\n"
                    + "			background: transparent;\n"
                    + "			border: 1px solid #fff;\n"
                    + "			color: #fff;\n"
                    + "		}\n"
                    + "\n"
                    + "		.btn.btn-black-outline {\n"
                    + "			border-radius: 0px;\n"
                    + "			background: transparent;\n"
                    + "			border: 2px solid #000;\n"
                    + "			color: #000;\n"
                    + "			font-weight: 700;\n"
                    + "		}\n"
                    + "\n"
                    + "		.btn-custom {\n"
                    + "			color: rgba(0, 0, 0, .3);\n"
                    + "			text-decoration: underline;\n"
                    + "		}\n"
                    + "\n"
                    + "		h1,\n"
                    + "		h2,\n"
                    + "		h3,\n"
                    + "		h4,\n"
                    + "		h5,\n"
                    + "		h6 {\n"
                    + "			font-family: 'Work Sans', sans-serif;\n"
                    + "			color: #000000;\n"
                    + "			margin-top: 0;\n"
                    + "			font-weight: 400;\n"
                    + "		}\n"
                    + "\n"
                    + "		body {\n"
                    + "			font-family: 'Work Sans', sans-serif;\n"
                    + "			font-weight: 400;\n"
                    + "			font-size: 15px;\n"
                    + "			line-height: 1.8;\n"
                    + "			color: rgba(0, 0, 0, .4);\n"
                    + "		}\n"
                    + "\n"
                    + "		a {\n"
                    + "			color: #17bebb;\n"
                    + "		}\n"
                    + "\n"
                    + "		table {}\n"
                    + "\n"
                    + "		/*LOGO*/\n"
                    + "\n"
                    + "		.logo h1 {\n"
                    + "			margin: 0;\n"
                    + "		}\n"
                    + "\n"
                    + "		.logo h1 a {\n"
                    + "			color: #17bebb;\n"
                    + "			font-size: 24px;\n"
                    + "			font-weight: 700;\n"
                    + "			font-family: 'Work Sans', sans-serif;\n"
                    + "		}\n"
                    + "\n"
                    + "		/*HERO*/\n"
                    + "		.hero {\n"
                    + "			position: relative;\n"
                    + "			z-index: 0;\n"
                    + "		}\n"
                    + "\n"
                    + "		.hero .text {\n"
                    + "			color: rgba(0, 0, 0, .3);\n"
                    + "		}\n"
                    + "\n"
                    + "		.hero .text h2 {\n"
                    + "			color: #000;\n"
                    + "			font-size: 34px;\n"
                    + "			margin-bottom: 15px;\n"
                    + "			font-weight: 300;\n"
                    + "			line-height: 1.2;\n"
                    + "		}\n"
                    + "\n"
                    + "		.hero .text h3 {\n"
                    + "			font-size: 24px;\n"
                    + "			font-weight: 200;\n"
                    + "		}\n"
                    + "\n"
                    + "		.hero .text h2 span {\n"
                    + "			font-weight: 600;\n"
                    + "			color: #000;\n"
                    + "		}\n"
                    + "\n"
                    + "\n"
                    + "		/*PRODUCT*/\n"
                    + "		.product-entry {\n"
                    + "			display: block;\n"
                    + "			position: relative;\n"
                    + "			float: left;\n"
                    + "			padding-top: 20px;\n"
                    + "		}\n"
                    + "\n"
                    + "		.product-entry .text {\n"
                    + "			width: calc(100% - 125px);\n"
                    + "			padding-left: 20px;\n"
                    + "		}\n"
                    + "\n"
                    + "		.product-entry .text h3 {\n"
                    + "			margin-bottom: 0;\n"
                    + "			padding-bottom: 0;\n"
                    + "		}\n"
                    + "\n"
                    + "		.product-entry .text p {\n"
                    + "			margin-top: 0;\n"
                    + "		}\n"
                    + "\n"
                    + "		.product-entry img,\n"
                    + "		.product-entry .text {\n"
                    + "			float: left;\n"
                    + "		}\n"
                    + "\n"
                    + "		ul.social {\n"
                    + "			padding: 0;\n"
                    + "		}\n"
                    + "\n"
                    + "		ul.social li {\n"
                    + "			display: inline-block;\n"
                    + "			margin-right: 10px;\n"
                    + "		}\n"
                    + "\n"
                    + "		/*FOOTER*/\n"
                    + "\n"
                    + "		.footer {\n"
                    + "			border-top: 1px solid rgba(0, 0, 0, .05);\n"
                    + "			color: rgba(0, 0, 0, .5);\n"
                    + "		}\n"
                    + "\n"
                    + "		.footer .heading {\n"
                    + "			color: #000;\n"
                    + "			font-size: 20px;\n"
                    + "		}\n"
                    + "\n"
                    + "		.footer ul {\n"
                    + "			margin: 0;\n"
                    + "			padding: 0;\n"
                    + "		}\n"
                    + "\n"
                    + "		.footer ul li {\n"
                    + "			list-style: none;\n"
                    + "			margin-bottom: 10px;\n"
                    + "		}\n"
                    + "\n"
                    + "		.footer ul li a {\n"
                    + "			color: rgba(0, 0, 0, 1);\n"
                    + "		}\n"
                    + "\n"
                    + "\n"
                    + "		@media screen and (max-width: 500px) {}\n"
                    + "	</style>\n"
                    + "\n"
                    + "\n"
                    + "</head>\n"
                    + "\n"
                    + "<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #f1f1f1;\">\n"
                    + "	<center style=\"width: 100%; background-color: #f1f1f1;\">\n"
                    + "		<div\n"
                    + "			style=\"display: none; font-size: 1px;max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: sans-serif;\">\n"
                    + "			&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;\n"
                    + "		</div>\n"
                    + "		<div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\n"
                    + "			<!-- BEGIN BODY -->\n"
                    + "			<table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\"\n"
                    + "				style=\"margin: auto;\">\n"
                    + "				<tr>\n"
                    + "					<td valign=\"top\" class=\"bg_white\" style=\"padding: 1em 2.5em 0 2.5em;\">\n"
                    + "						<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                    + "							<tr>\n"
                    + "								<td class=\"logo\" style=\"text-align: left;\">\n"
                    + "									<img style=\"height: 80px;\" src=\"../assets/img/header/logo2.png\"/>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "						</table>\n"
                    + "					</td>\n"
                    + "				</tr><!-- end tr -->\n"
                    + "				<tr>\n"
                    + "					<td valign=\"middle\" class=\"hero bg_white\" style=\"padding: 2em 0 2em 0;\">\n"
                    + "						<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                    + "							<tr>\n"
                    + "								<td style=\"padding: 0 2.5em; text-align: left;\">\n"
                    + "									<div class=\"text\">\n"
                    + "										<h2>Thank you for your order</h2>\n"
                    + "										<h3>Your order</h3>\n"
                    + "									</div>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "						</table>\n"
                    + "					</td>\n"
                    + "				</tr><!-- end tr -->\n"
                    + "				<tr>\n"
                    + "					<table class=\"bg_white\" role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                    + "						<tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n"
                    + "							<th width=\"80%\"\n"
                    + "								style=\"text-align:left; padding: 0 2.5em; color: #000; padding-bottom: 20px\">Item</th>\n"
                    + "							<th width=\"20%\"\n"
                    + "								style=\"text-align:right; padding: 0 2.5em; color: #000; padding-bottom: 20px\">Price</th>\n"
                    + "						</tr>\n";
            for (int i = 0; i < c.getItems().size(); i++) {
                content += "						<tr style=\"border-bottom: 1px solid rgba(0,0,0,.05);\">\n"
                        + "							<td valign=\"middle\" width=\"80%\" style=\"text-align:left; padding: 0 2.5em;\">\n"
                        + "								<div class=\"product-entry\">\n"
                        + "									<img src=\"" + c.getItems().get(i).getProduct().getImg() + "main.jpg" + "\" alt=\"\"\n"
                        + "										style=\"width: 100px; max-width: 600px; height: auto; margin-bottom: 20px; display: block;\">\n"
                        + "									<div class=\"text\">\n"
                        + "										<h3>" + c.getItems().get(i).getProduct().getName() + "</h3>\n"
                        + "									</div>\n"
                        + "								</div>\n"
                        + "							</td>\n"
                        + "							<td valign=\"middle\" width=\"20%\" style=\"text-align:left; padding: 0 2.5em;\">\n"
                        + "								<span class=\"price\" style=\"color: #000; font-size: 20px;\">" + c.getItems().get(i).getPrice() + "</span>\n"
                        + "							</td>\n"
                        + "						</tr>\n";
            }
            content
                    += "						<tr>\n"
                    + "							<td valign=\"middle\" width=\"80%\" style=\"text-align:left; padding: 0 2.5em;\">\n"
                    + "								<p style=\"font-size: 25px;\">Total</p>\n"
                    + "							</td>\n"
                    + "							<td valign=\"middle\" width=\"20%\" style=\"text-align:left; padding: 0 2.5em;\">\n"
                    + "								<span class=\"price\" style=\"color: #000; font-size: 20px;\">" + c.getTotalMoney() + "</span>\n"
                    + "							</td>\n"
                    + "						</tr>\n"
                    + "					</table>\n"
                    + "				</tr><!-- end tr -->\n"
                    + "				<!-- 1 Column Text + Button : END -->\n"
                    + "			</table>\n"
                    + "		</div>\n"
                    + "	</center>\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            msg.setContent(content, "text/html");
            Transport.send(msg);
        } catch (Exception e) {
            System.out.println(e);
        }

        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
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
