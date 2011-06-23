package project;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitybean.Tblfaq;
import entitybean.Tblproject;
import entitybean.Tblprojecttype;

import sessionbean.dao.FaqDaoRemote;
import sessionbean.dao.ProjectDaoRemote;
import sessionbean.dao.ProjectTypeDaoRemote;

/**
 * Servlet implementation class addDel_project
 */
public class addDel_project extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_project() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean getresult;
		getresult = false;

		if(request.getParameter("ID")!= null)
		{
			int projectId = Integer.parseInt(request.getParameter("ID"));
			try {
				InitialContext context = new InitialContext();
				ProjectDaoRemote delproject = (ProjectDaoRemote)context.lookup("ProjectDao/remote");
				getresult = delproject.remove(projectId);	
			} catch (NamingException e) {
				getresult = false;
			}
		}
		if(getresult == false){
			request.setAttribute("result", "Delete false");
		}else{
			request.setAttribute("result", "Delete sucess");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("projects_admin02.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmdCommand = request.getParameter("submit").trim();
		String projectname = request.getParameter("projectname").trim();
		String description = request.getParameter("editor1").trim();
		String image = request.getParameter("image").trim();
		String ProjectTypeID = request.getParameter("projecttype").trim();
		String projectID = request.getParameter("projectID").trim();
	
		if(image.length() == 0){
			image = "Noimage.jpg";
		}
		
		boolean result = false;
		try {
			InitialContext context = new InitialContext();
			ProjectDaoRemote updateproject = (ProjectDaoRemote)context.lookup("ProjectDao/remote");
			ProjectTypeDaoRemote getprojecttype = (ProjectTypeDaoRemote)context.lookup("ProjectTypeDao/remote");
			
			Tblproject addproject = new Tblproject();
			addproject.setDescription(description);
			addproject.setProjectname(projectname);
			addproject.setImage(image);
			
			Tblprojecttype projecttypeid = new Tblprojecttype();
			projecttypeid = getprojecttype.findByID(Integer.parseInt(ProjectTypeID));
			addproject.setProjecttypeid(projecttypeid);
			
			if(cmdCommand.equals("Insert")){
				result = updateproject.add(addproject);
			}else{
				addproject.setId(Integer.parseInt(projectID));
				result = updateproject.update(addproject);
			}
				
		} catch (NamingException e) {
			e.printStackTrace();
		}					
		response.sendRedirect("projects_admin02.jsp");
	}

}
