package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginProcessing
 */
public class LoginProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcessing() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SqlServerDriver");
			Connection connect;
			connect = DriverManager.getConnection("jdbc:sqlserver://localhost",
					"sa", "331536964");
			Statement state;
			String studentID, actNo, password, pwd;
			state = connect.createStatement();
			studentID = (String) request.getParameter("txtUser");
			password = (String) request.getParameter("txtPass");
			password = password.trim();
			studentID = studentID.trim();
			String strQuery1 = "select * from Account where StudentID=’"
					+ studentID + "'";
			ResultSet result1 = state.executeQuery(strQuery1);

			while (result1.next()) {
				actNo = (String) result1.getString("StudentID");
				pwd = (String) result1.getString("Password");
				actNo = actNo.trim();
				pwd = pwd.trim();

				if ((actNo.equals(studentID)) && (pwd.equals(password))
						&& (actNo.length() != 0) && (pwd.length() != 0)) {
					String strQuery2 = "select * from Student where StudentID=’"
						+ studentID + "'";
					ResultSet result2 = state.executeQuery(strQuery2);
					while (result2.next()) {
						String studentIDDetail = (String) result2.getString("StudentID");
						String studentNameDetail = (String) result2.getString("StudentName");
						out.println("Student details : <br/>");
						out.println("ID : " + studentIDDetail + "<br/>");
						out.println("Name : " + studentNameDetail + "<br/>");
					}
				} else {
					out.println("Username or password invalid!");
				}
			}
		} catch (Exception e) {

		} 
	}

}
