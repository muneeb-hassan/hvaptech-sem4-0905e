package userdetail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitybean.Tbluserdetail;

import sessionbean.dao.UserDetailDaoRemote;

/**
 * Servlet implementation class addDel_user
 */
public class addDel_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    try{
	        int userid = 0;
	        userid = Integer.parseInt(request.getParameter("userid").trim());
	        if(userid > 0){
	            String action = request.getParameter("action").trim();
	            InitialContext ctx = new InitialContext();
	            UserDetailDaoRemote uDao = (UserDetailDaoRemote)ctx.lookup("UserDetailDao/remote");
	            Tbluserdetail user = uDao.findByID(userid);
	            if(user != null){
	                if("lock".equals(action)){
	                    uDao.lockUser(user);
	                }else if("active".equals(action)){
	                    uDao.activeUser(user);
	                }
	            }
	        }
	        response.sendRedirect("user_admin02.jsp");
	    }catch (Exception e) {
            // TODO: handle exception
	        e.printStackTrace();
	        response.sendRedirect("user_admin02.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
