package about;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbean.dao.AboutUsDaoRemote;
import entitybean.Tblaboutus;

/**
 * Servlet implementation class addDel_about
 */
public class addDel_about extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_about() {
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

		String cmdCommand = request.getParameter("submit").trim();
		String aboutdetail = request.getParameter("editor1").trim();
		String AboutID = "";
		
		if(request.getParameter("AboutID") != null && !request.getParameter("AboutID").isEmpty()){
			AboutID = request.getParameter("AboutID");
		}
		
		boolean result = false;
		try {
			InitialContext context = new InitialContext();
			AboutUsDaoRemote aboutAdmin = (AboutUsDaoRemote)context.lookup("AboutUsDao/remote");
			Tblaboutus addabout = new Tblaboutus();
			addabout.setIntroduction(aboutdetail);
			if("Insert".equals(cmdCommand)){
				result = aboutAdmin.add(addabout);
			}else{
				addabout.setId(Integer.parseInt(AboutID));
				result = aboutAdmin.update(addabout);
			}
				
		} catch (NamingException e) {
			e.printStackTrace();
		}					
		response.sendRedirect("about_admin02.jsp");

	}

}
