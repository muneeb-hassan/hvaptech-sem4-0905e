/*
 * SessionDisplay.java
 *
 * This program creates a servlet that uses HttpSession for session tracking.
 *
 *Copyright © 2007 Aptech Software Limited. All rights reserved.
 *
 */

package servlet;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

/* 
 * @author Vincent
 * 
 */
/* SessionDisplay class allows the user to track the user session*/
public class SessionDisplay extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
     /* sets content type */        
        response.setContentType("text/html;charset=UTF-8");
        
        /*The getWriter method obtains an output stream on which to write text, 
         which happens to be an instance of the PrintWriter class. */        
        PrintWriter out = response.getWriter();
        
        /*Returns the current session associated with this request, 
         or if the request does not have a session, creates one.*/        
        HttpSession session = request.getSession();
        
        /* Gets the creation time*/               
        Date creationTime = new Date(session.getCreationTime());
        
        /* Gets the last accessed time*/        
        Date lastAccessed = new Date(session. getLastAccessedTime());
        
        /* Gets the new date */
        Date now = new Date();
        
        /* Formats the date*/
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        /* Displays the output */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Displaying the Session Creation and Last-Accessed Time</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to Shop Stop</h1>");
        out.println("<h2>Session Creation and Last-Accessed Time</h2>");
        out.println("The time and date now is: " + formatter.format(now) + "<br><br>");
        out.println("The session creation time:" + "HttpSession.getCreationTime(): " + formatter.format(creationTime) + "<br><br>");
        out.println("The last time the session was accessed:HttpSession.getLastAccessedTime( ): " + formatter.format(lastAccessed));
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
    // </editor-fold>
}
