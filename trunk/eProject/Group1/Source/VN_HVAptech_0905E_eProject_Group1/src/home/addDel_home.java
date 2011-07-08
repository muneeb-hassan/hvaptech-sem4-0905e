package home;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.Update;

import sessionbean.dao.HomeDaoRemote;
import entitybean.Tblhome;

/**
 * Servlet implementation class addDel_home
 */
public class addDel_home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_home() {
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
    	String mainintrodution=request.getParameter("mainintrodution");
    	String domainintrodution=request.getParameter("domainintrodution");
    	String serviceintrodution=request.getParameter("serviceintrodution");
    	String command = request.getParameter("submit");
    	int homeID = 0;
    	boolean result = false;
    	
		try{
		    InitialContext context = new InitialContext();
		    HomeDaoRemote UpdateHome = (HomeDaoRemote)context.lookup("HomeDao/remote");
		    if(command.equals("Insert")){
		     	Tblhome addhome = new Tblhome();
		     	addhome.setDomainintrodution(domainintrodution);
		     	addhome.setServiceintrodution(serviceintrodution);
		     	addhome.setMainintrodution(mainintrodution);
		     	UpdateHome.add(addhome);
		    }else{
		    	homeID = Integer.parseInt(request.getParameter("homeID"));
		    	if(command.equals("Delete")){
		    		UpdateHome.remove(homeID);
		    	}else{
			     	Tblhome updatehome = new Tblhome();
			     	updatehome.setDomainintrodution(domainintrodution);
			     	updatehome.setServiceintrodution(serviceintrodution);
			     	updatehome.setMainintrodution(mainintrodution);
			     	updatehome.setId(homeID);
			     	UpdateHome.update(updatehome);		    		
		    	}
		    }
		}catch(Exception e){
			response.sendRedirect("index.jsp");
		}
		response.sendRedirect("index.jsp");
	}

}
