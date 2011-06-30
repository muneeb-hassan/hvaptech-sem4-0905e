package addtocart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class addcart
 */
public class addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<getDomain> DomainList;
	private List<getService> ServiceList;
	
    public addcart() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ID = request.getParameter("ID");
		String messageOrderCus = "";
		HttpSession session = request.getSession();
		try {
			if (ID.equals("clearcart")) {
				if(session.getAttribute("ServiceList")!=null)
					session.removeAttribute("ServiceList");
				if(session.getAttribute("DomainList")!=null)
					session.removeAttribute("DomainList");
				if(DomainList != null)
					DomainList.clear();
				if(ServiceList !=null)
					ServiceList.clear();
				response.sendRedirect("userorder.jsp");
			} else {
				InitialContext context = new InitialContext();
				ServiceDaoRemote find_service = (ServiceDaoRemote) context.lookup("ServiceDao/remote");
				Tblservice Servicelst = find_service.findByID(Integer.parseInt(ID));
				Tbldomain Domainlst = find_service.getDomainByServiceID(Integer.parseInt(ID));

				getService addService = new getService(Servicelst.getId(),
						Servicelst.getDescription(), Servicelst.getDomainid()
								.getId());
				getDomain addDomain = new getDomain(Domainlst.getId(),Domainlst.getDomainname());
				
				//Check Array and Session
				if (ServiceList == null) {
					ServiceList = new ArrayList<getService>();
				}
				if (DomainList == null) {
					DomainList = new ArrayList<getDomain>();
				}
				if (session.getAttribute("ServiceList") != null) {
					ServiceList = (List<addtocart.getService>) session
							.getAttribute("ServiceList");
				}
				if (session.getAttribute("DomainList") != null) {
					DomainList = (List<addtocart.getDomain>) session
							.getAttribute("DomainList");
				}
				
				//Add Service
				boolean add_Service = false;
				if (ServiceList.size() == 0) {
					add_Service = true;
				} else {
					for (getService p : ServiceList) {
						if (p.getIdService() != Integer.parseInt(ID)) {
							add_Service = true;
						} else {
							add_Service = false;
						}
					}
				}
				if (add_Service == true) {
					ServiceList.add(addService);
				}
				
				//Add Domain
				boolean add_Domain = false;
				if (DomainList.size() == 0) {
					add_Domain = true;
				} else {
					for (getDomain p : DomainList) {
						if (p.getIdDomain() != addDomain.getIdDomain()) {
							add_Domain = true;
						} else {
							add_Domain = false;
						}
					}
				}
				if (add_Domain == true) {
					DomainList.add(addDomain);
				}

				session.setAttribute("ServiceList", ServiceList);
				session.setAttribute("DomainList", DomainList);
			}
		} catch (Exception e) {
			messageOrderCus = "Error system.";
		}
		response.sendRedirect("userorder.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
