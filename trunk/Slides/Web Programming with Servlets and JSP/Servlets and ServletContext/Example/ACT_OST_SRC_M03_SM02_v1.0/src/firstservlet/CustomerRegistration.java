/*
 * CustomerRegistration.java
 *
 * This program demonstrates the creation of a servlet program that uses 
 * servletRequest method and display attributes
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package firstservlet;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
/** CustomerRegistration class stores information about a customer to be 
     * registered.
     * 
     * @author vincent
     */
public class CustomerRegistration extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title> CustomerRegistration </title></head>");
        out.println("<body bgcolor=\"#ffffff\">");
        String UserId=request.getParameter("txtuserid");
        String Password=request.getParameter("txtpassword");
        String FirstName=request.getParameter("txtname");
        String Gender=request.getParameter("rbgender");
        String Age=request.getParameter("txtage");
        out.println("<table border=0 align=center width=50%>");
        out.println("<tr><td colspan=2><center><font color=red size=6>CustomerRegistration Details</font></center></td></tr>");
        out.println("<tr><td>UserId:</td><td><Font Color=red Face=Georgia>"+UserId+"</Font></td></tr>");
        out.println("<r><td>Password:</td><td><Font Color=red Face=Georgia>"+Password+"</Font></td></tr>");
        out.println("<tr><td>Name:</td><td><Font Color=red Face=Georgia>"+FirstName+"</Font></td></tr>");
        out.println("<tr><td>Gender:</td><td><Font Color=red Face=Georgia>"+Gender+"</Font></td></tr>");
        out.println("<tr><td>Age:</td><td><Font Color=red Face=Georgia>"+Age+"</Font></td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Version 1.0, written by Vincent";
    }
}