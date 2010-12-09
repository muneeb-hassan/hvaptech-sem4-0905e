package jservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Getting request params
		String userName = request.getAttribute("userName").toString();
		
		/* Generate HTML */
		  response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          try {
              // TODO output your page here
              out.println("<html>");
              out.println("<head>");
              out.println("<title>Welcome Servlet</title>");
              out.println("</head>");
              out.println("<body>");
              out.println("<h1>Hello , <b>" + userName  + "</b></h1>");
              out.println("</body>");
              out.println("</html>");
          } finally {
              out.close();
          }
	}

}
