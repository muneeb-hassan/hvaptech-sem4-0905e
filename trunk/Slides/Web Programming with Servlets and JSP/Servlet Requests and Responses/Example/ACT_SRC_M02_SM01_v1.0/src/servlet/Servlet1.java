/*Servlet1.java
 *
 * This servlet program reads the parameters and headers from a client request
 * 
 * Copyright © 2007 Aptech Software Limited. All rights reserved.*/
 package servlet;
/* @ author vincent */
import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.String;
public class Servlet1 extends HttpServlet {
   public void doGet (HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        response.setContentType("text/html");
        String s = request.getParameter("l");
        String qs = request.getQueryString();
        Enumeration e = request.getHeaderNames();
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<B>Hello </B>"+ s);
        out.println ("<B>Query String:</B>"+qs);
        out.println("<br> Header </br>"+ e);
        out.println("</BODY></HTML>");
     }
}