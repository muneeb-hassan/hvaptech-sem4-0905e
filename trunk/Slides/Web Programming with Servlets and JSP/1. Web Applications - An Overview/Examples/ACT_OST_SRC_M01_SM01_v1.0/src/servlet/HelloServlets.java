/*
 * HelloServlets.java
 *
 * This program demonstrates the creation of a simple servlet application
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package servlet;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * HelloServlets class displays HelloServlets on the screen
 *
 * @author vincent
 */
public class HelloServlets extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here*/
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HelloServlets</title>");
        out.println("</head>");
        out.println("<body>");
        //Displays "HelloServlets" on the screen
        out.println("<h1>HelloServlets</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Version 1.0, written by Vincent";
    }
}
