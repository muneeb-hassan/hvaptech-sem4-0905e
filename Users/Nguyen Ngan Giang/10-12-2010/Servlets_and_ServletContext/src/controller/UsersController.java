package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import util.DataUtil;
import util.LogUtil;
import model.StudentLoginModel;
import dao.UserDAO;

/**
 * Servlet implementation class UsersController
 */
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger loggerInfo = Logger.getLogger("LogINFO");
	
    /**
     * @see HttpServlet#HttpServlet()
     */

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
		
		String actionType = request.getParameter("actionType").toString();
		if(actionType.equalsIgnoreCase("login")){
			doPostLogin(request, response);
		}
	}

	private void doPostLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("txtUser");
		String password = request.getParameter("txtPass");
		StudentLoginModel studentLoginModel = UserDAO.userDetails(username);
		
			if(username != "" && password != "" && studentLoginModel != null && studentLoginModel.getStudentID().equals(username)
					&& studentLoginModel.getPassword().equals(password)){
						LogUtil.logInfo(loggerInfo, username + " login");
						response.sendRedirect("index.jsp");
			} else  {
						LogUtil.logInfo(loggerInfo, "Username or password invalid!");
						response.sendRedirect("ErrorLogin.jsp");
			}
	}
}

