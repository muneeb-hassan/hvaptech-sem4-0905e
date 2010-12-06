/*
 * InitCounter.java
 *
 * This program demonstrates the initialisation of a servlet using the init parameter
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * InitCounter class initializes the count variable and increases the counter
 * by one each time a page is refreshed
 *
 * @author vincent
 */
public class InitCounter extends HttpServlet {
    
    int count;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String initial = config.getInitParameter("initial");
        try {
            count = Integer.parseInt(initial);
        } catch (NumberFormatException e) {
            count = 0;
        }
       }
     public void doGet(HttpServletRequest req, HttpServletResponse res) 
                           throws ServletException, IOException {
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();
    count++;
    out.println("Since loading (and with a possible initialization");
    out.println("parameter figured in), this servlet has been accessed");
    out.println(count + " times.");
  }

}   
    
        
