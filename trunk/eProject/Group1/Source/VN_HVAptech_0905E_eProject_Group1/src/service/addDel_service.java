package service;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sessionbean.dao.DomainDaoRemote;
import sessionbean.dao.ServiceDaoRemote;
import entitybean.Tbldomain;
import entitybean.Tblservice;

/**
 * Servlet implementation class addDel_service
 */
public class addDel_service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id;
		id = request.getParameter("ID").trim();
		session.setAttribute("domainid", id);
		response.sendRedirect("services_admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String service;
		String serviceid;
		String domainid;
		String cmdCommand = request.getParameter("submit").trim();
		boolean result = false;
		try{
            InitialContext context = new InitialContext();
            ServiceDaoRemote serviceadmin = (ServiceDaoRemote)context.lookup("ServiceDao/remote");
            DomainDaoRemote domainadmin = (DomainDaoRemote)context.lookup("DomainDao/remote");
            
            Tblservice addservice = new Tblservice();
            Tbldomain getdomain = new Tbldomain();
            
            service = request.getParameter("service").trim();
            domainid = request.getParameter("domainlist").trim();
            getdomain = domainadmin.findByID(Integer.parseInt(domainid));
            
            addservice.setDescription(service);
            addservice.setDomainid(getdomain);
            
			if(cmdCommand.equals("Insert")){
				result = serviceadmin.add(addservice);
			}else{
				serviceid = request.getParameter("serviceid").trim();
				addservice.setId(Integer.parseInt(serviceid));
				result = serviceadmin.update(addservice);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("services_admin.jsp");		
	}

}
