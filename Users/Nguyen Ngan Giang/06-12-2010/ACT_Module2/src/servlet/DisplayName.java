package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayName
 */
public class DisplayName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>User Information</title></head>");
		out.println("<body>");
		out.println("<br/><u>User's Information :</u>");
		out.println("<br/>First Name : " + firstName);
		out.println("<br/>Last Name : " + lastName);
		out.println("<hr/>");
		out.println("<br/><u>Server's Information :</u>");
		out.println("<br/>Remote host : " + request.getRemoteHost());
		out.println("<br/>Remote port : " + request.getRemotePort());
		out.println("<br/>Requested URI : " + request.getRequestURI());
		out.println("<br/>Server name : " + request.getServerName());
		out.println("<br/>Server port : " + request.getServerPort());
		out.println("</body></html>");
	}

}
