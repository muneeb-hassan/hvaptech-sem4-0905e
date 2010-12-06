/*
 * DisplayError.java
 *
 * This program displays the error message for the specified error
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** DisplayError class displays error for the error message
     * 
     * @author vincent
     */
public class DisplayError extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String code = null, message = null, type = null, uri = null;
        Object codeObj, messageObj, typeObj;
        Throwable throwable;
        
        codeObj = req.getAttribute("javax.servlet.error.status_code");
        messageObj = req.getAttribute("javax.servlet.error.message");
        typeObj = req.getAttribute("javax.servlet.error.exception_type");
        throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        uri = (String) req.getAttribute("javax.servlet.error.request_uri");
        
        if (uri == null) {
            uri = req.getRequestURI(); // in case there's no URI given
        }
        
        // Convert the attributes to string values
        if (codeObj != null)
            code = codeObj.toString();
        if (messageObj != null)
            message = messageObj.toString();
        if (typeObj != null)
            type = typeObj.toString();
        
        // The error reason is either the status code or exception type
        String reason = (code != null ? code : type);
        
        out.println("<HTML>");
        out.println("<HEAD><TITLE>" + reason + ": " + message + "</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1>" + reason + "</H1>");
        out.println("<H2>" + message + "</H2>");
        out.println("<PRE>");
        if (throwable != null) {
            throwable.printStackTrace(out);
        }
        out.println("</PRE>");
        out.println("<HR>");
        out.println("<I>Error accessing " + uri + "</I>");
        out.println("</BODY></HTML>");
    }
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    /*
     * if the servlet tries to access a resource that is forbidden for this
     * client and there is no further information on it - "403 Forbidden"
     */
        response.sendError(404);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Version 1.0, written by Vincent";
    }
}
