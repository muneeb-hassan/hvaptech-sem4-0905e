/*
 * Thrower.java
 *
 * This program throws a response to the error sent by Sender
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** Thrower class sends a response to the error sent by sender 
     * 
     * @author vincent
     */
public class Thrower extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
        throw new java.io.IOException("IO thrown");
        //response.sendError(403);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
        doPost(request, response);
    }
}
