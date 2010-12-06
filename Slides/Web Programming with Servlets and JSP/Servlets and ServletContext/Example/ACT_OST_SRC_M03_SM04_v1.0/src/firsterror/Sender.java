/*
 * Sender.java
 *
 * This program sends a response to the specified error
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** Sender class sends a response to the specified error 
     * 
     * @author vincent
     */
public class Sender extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
    /*
     * if the servlet tries to access a resource and finds out that the
     * client is not authorized to access it - "401 Unauthorized"
     */
        //response.sendError(401,"You are not authorized to view the requested
        // component");
    /*
     * if the servlet tries to access a resource that is forbidden for this
     * client and there is no further information on it - "403 Forbidden"
     */
        response.sendError(404);
        
    /*
     * if the servlet tries to access a resource that is not found given the
     * client's provided URL - "404 Not Found"
     */
        //response.sendError(404);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
    }
}
