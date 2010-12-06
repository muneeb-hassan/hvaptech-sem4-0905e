/*
 * ErrorGenerate.java
 *
 * This program generates the error for a specified error
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** ErrorGenerate class generatess an error for the specified error
     * 
     * @author vincent
     */
public class ErrorGenerate extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {

    //check the servlet exception
    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
    String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
    if (servletName == null)
      servletName = "Unknown";

    String requestUri = (String) request
        .getAttribute("javax.servlet.error.request_uri");
    if (requestUri == null)
      requestUri = "Unknown";

    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Error page</title>");
    out.println("</head>");
    out.println("<body>");
    if (throwable == null) {
      out.println("<h2>The error information is not available</h2>");
      out.println("Please return to the <a href=\""
          + response.encodeURL("http://www.java2s.com")
          + "\">home page</a>");
    } else {
      out.println("<h2>Here is the error information</h2>");
      out.println("The servlet name associated with throwing the exception: "
              + servletName + "<br><br>");
      out.println("The type of exception: "
          + throwable.getClass().getName() + "<br><br>");
      out.println("The request URI: " + requestUri + "<br><br>");
      out.println("The exception message: " + throwable.getMessage());
    }
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    doPost(request, response);
  }
}
