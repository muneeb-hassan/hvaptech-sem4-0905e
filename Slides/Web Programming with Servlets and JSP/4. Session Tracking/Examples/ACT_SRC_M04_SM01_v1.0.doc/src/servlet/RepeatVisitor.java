/*
 * RepeatVisitor.java
 *
 * This program creates a servlet that uses Cookies for session tracking.
 *  
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * @author vincent
 *
 */
/* RepeatVisitor class allows the user to know to first-time
 *  visitors and the repeat visitors.*/
 
public class RepeatVisitor extends HttpServlet {
    /* doGet method is called by the server to allow a servlet to handle a GET request.
     This method throws ServletException and IOException when the request for the GET 
     could not be handled and input or output error is detected 
     when the servlet handles the GET request,respectively */
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
     /* Declaring boolean object newbie as true */  
    boolean newbie = true;
     /*Returns the array of cookie object */ 
    Cookie[] cookies = request.getCookies();
    /* Getting the Value of a Cookie with a Specified Name*/
    if (cookies != null) {
      for(int i=0; i<cookies.length; i++) {
        Cookie c = cookies[i];
        if ((c.getName().equals("repeatVisitor")) &&
            // Could omit test and treat cookie name as a flag
            (c.getValue().equals("yes"))) {
          newbie = false;
          break;
        }
      }
    }
    String title;
    /* Declaring new cookie object returnVisitorCookie */ 
    if (newbie) {
      Cookie returnVisitorCookie =
        new Cookie("repeatVisitor", "yes");
      /* setting the age of cookie */ 
      returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
      /*The cookie returnVisitorCookie is added to the response header by means 
       of the addCookie method of HttpServletResponse */ 
      response.addCookie(returnVisitorCookie);
      title = "Welcome Aboard";
    } else {
      title = "Welcome Back";
    }
    /* Text content of the response is sent to the Web server in HTML format*/ 
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "</BODY></HTML>");
  }
}
