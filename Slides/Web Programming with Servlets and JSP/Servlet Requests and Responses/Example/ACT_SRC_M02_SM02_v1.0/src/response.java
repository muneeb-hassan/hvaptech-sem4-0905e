/*response.java
 *
 * This servlet program sends information to client
 * 
 * Copyright © 2007 Aptech Software Limited. All rights reserved.*/
 
/* @ author vincent */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class response extends HttpServlet 
{   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        ServletOutputStream out = response.getOutputStream();
        String fileName = request.getParameter("1");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Client</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>This is a Server Response</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}
