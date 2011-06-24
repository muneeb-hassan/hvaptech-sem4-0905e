package userdetail;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entitybean.Tbluserdetail;

import sessionbean.dao.ProjectDaoRemote;
import sessionbean.dao.UserDetailDaoRemote;

/**
 * Servlet implementation class registeruser
 */
public class registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registeruser() {
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
		boolean getresult = false;
		String fullname = request.getParameter("fullname").trim();
		String address = request.getParameter("address").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		String messageUser;
		
		HttpSession session = request.getSession();
		
		try {
			InitialContext context = new InitialContext();
			UserDetailDaoRemote addUser = (UserDetailDaoRemote)context.lookup("UserDetailDao/remote");
			getresult = addUser.isExist(email);
			
			if(getresult == true){
				 messageUser = "Email was registered. Please choose another Email";
				 session.setAttribute("messageUser", messageUser);
				 response.sendRedirect("register.jsp");
			}else{
				Tbluserdetail user = new Tbluserdetail();
				user.setFullname(fullname);
				user.setAddress(address);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPassword(password);
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
