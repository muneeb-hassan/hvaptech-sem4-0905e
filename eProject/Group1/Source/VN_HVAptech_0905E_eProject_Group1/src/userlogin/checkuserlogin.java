package userlogin;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entitybean.Tbluserdetail;

import sessionbean.dao.LevelDaoRemote;
import sessionbean.dao.UserDetailDaoRemote;

/**
 * Servlet implementation class checkuserlogin
 */
public class checkuserlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkuserlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email;
		String password;
		String fullname;
		String messageLogin;
		boolean acceptuser = false;
		int userrole;
		
		email = request.getParameter("email").trim();
		password = request.getParameter("password").trim();
		
		HttpSession session = request.getSession();
		
		try{
			InitialContext context = new InitialContext();
			UserDetailDaoRemote checkUser = (UserDetailDaoRemote)context.lookup("UserDetailDao/remote");
			LevelDaoRemote getLevel = (LevelDaoRemote)context.lookup("LevelDao/remote");
			
			Tbluserdetail userdetail = new Tbluserdetail();
			userdetail = checkUser.findByEmailAndPassword(email, password);
			
			if(userdetail != null){
				acceptuser = userdetail.isIsactive();
				if(acceptuser == true){
					fullname = userdetail.getFullname();
					userrole = userdetail.getLevelid().getId();
				
					session.setAttribute("fullname", fullname);
					session.setAttribute("useremail", email);
					session.setAttribute("userrole",userrole);
					session.setAttribute("acceptuser", acceptuser);
					messageLogin = "Login success";
				}else{
					messageLogin = "Account is denied.Please contact admin.";
				}
			}else{
				messageLogin = "UserID or password doesn't correct. Please check again.";
			}
			
		}catch (Exception e) {
			messageLogin = "System error. Please login later.";
		}
		session.setAttribute("messageLogin", messageLogin);
		response.sendRedirect("index.jsp");
	}

}
