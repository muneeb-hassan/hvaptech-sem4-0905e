package userdetail;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hsqldb.Trigger;

import entitybean.Tbllevel;
import entitybean.Tbluserdetail;

import sessionbean.dao.LevelDaoRemote;
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
		boolean acceptuser = false;
		String fullname = request.getParameter("fullname").trim();
		String address = request.getParameter("address").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		String datebirth = request.getParameter("datebirth").trim();
		int userrole;
		String messageUser;
		
		HttpSession session = request.getSession();
		
		try {
			InitialContext context = new InitialContext();
			UserDetailDaoRemote addUser = (UserDetailDaoRemote)context.lookup("UserDetailDao/remote");
			LevelDaoRemote getLevel = (LevelDaoRemote)context.lookup("LevelDao/remote");
			
			getresult = addUser.isExist(email);
			
			if(getresult == true){
				 messageUser = "Email was registered. Please choose another Email";
			}else{
				Tbluserdetail user = new Tbluserdetail();
				user.setFullname(fullname);
				user.setAddress(address);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPassword(password);
				
				if(request.getParameter("sex").equals("Male")){
					user.setSex(true);
				}else{
					user.setSex(false);
				}
				
				user.setDatebirth(datebirth);
				user.setIsactive(true);
				
				Tbllevel levelid = new Tbllevel();
				userrole = 1;
				levelid = getLevel.findByID(userrole);
				user.setLevelid(levelid);				
				
				getresult = addUser.add(user);
				if(getresult == true){
					messageUser = "Register success";
					session.setAttribute("fullname", fullname);
					session.setAttribute("useremail", email);
					session.setAttribute("userrole",userrole);
					acceptuser = true;
					session.setAttribute("acceptuser", acceptuser);					
				}else{
					messageUser = "Resgister false. Please register again.";
				}

			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			messageUser = "Error system. Please register later.";
		}
		session.setAttribute("messageUser", messageUser);
		response.sendRedirect("register.jsp");
	}

}
