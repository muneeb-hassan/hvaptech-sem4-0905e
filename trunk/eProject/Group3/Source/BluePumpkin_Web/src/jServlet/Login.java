package jServlet;

import jSessions.UserDAORemote;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		try{
			String action = request.getParameter("Action");
			if(action.equals("Login")){
				String user = request.getParameter("txtUser");
				String pass = request.getParameter("txtPass");
				Context context = new InitialContext();
				UserDAORemote userDao = (UserDAORemote)context.lookup("UserDAO/remote");
				boolean result = userDao.checkUserAndPass(user, pass);
				String url = "fail.jsp";
				if(result){
					HttpSession session = request.getSession(true);
					session.setAttribute("USER", user);
					url = "index.jsp";
				}
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
