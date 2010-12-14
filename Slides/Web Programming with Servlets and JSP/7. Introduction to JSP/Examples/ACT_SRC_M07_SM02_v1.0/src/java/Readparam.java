/*
 * Readparam.java
 *
 * Created on July 4, 2007, 10:30 AM
 */

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author vidyashreem
 * @version
 */
public class Readparam extends HttpServlet {
   public void doGet (HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
        res.setContentType("text/html");
        String s = req.getParameter("l");
        String qs = req.getQueryString();
        PrintWriter out = res.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<B>Hello </B>"+ s);
        out.println ("<B>Query String:</B>"+qs);
        out.println("</BODY></HTML>");
   }
}


    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
  
