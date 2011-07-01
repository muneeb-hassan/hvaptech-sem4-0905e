package addtocart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
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
			String username = session.getAttribute("useremail").toString();
			String sessionServiceList = "ServiceList" + username;
			String sessionDomainList = "DomainList" + username;

			InitialContext context = new InitialContext();
			ServiceDaoRemote find_service = (ServiceDaoRemote) context
					.lookup("ServiceDao/remote");
			Tblservice Servicelst = find_service.findByID(Integer.parseInt(ID));
			Tbldomain Domainlst = find_service.getDomainByServiceID(Integer
					.parseInt(ID));

			getService addService = new getService(Servicelst.getId(),
					Servicelst.getDescription(), Servicelst.getDomainid()
							.getId());
			getDomain addDomain = new getDomain(Domainlst.getId(),
					Domainlst.getDomainname());

			// Check Array and Session
			if (ServiceList == null) {
				ServiceList = new ArrayList<getService>();
			}
			if (DomainList == null) {
				DomainList = new ArrayList<getDomain>();
			}

			if (session.getAttribute(sessionServiceList) != null) {
				ServiceList = (List<addtocart.getService>) session
						.getAttribute(sessionServiceList);
			} else {
				if (session.getAttribute(sessionServiceList) == null
						&& ServiceList != null) {
					ServiceList.clear();
				}
			}
			if (session.getAttribute(sessionDomainList) != null) {
				DomainList = (List<addtocart.getDomain>) session
						.getAttribute(sessionDomainList);
			} else {
				if (session.getAttribute(sessionDomainList) == null
						&& DomainList != null) {
					DomainList.clear();
				}
			}

			// Add Service
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

			// Add Domain
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

			session.setAttribute(sessionServiceList, ServiceList);
			session.setAttribute(sessionDomainList, DomainList);

		} catch (Exception e) {
			messageOrderCus = "Error system.";
		}
		RequestDispatcher rd = request.getRequestDispatcher("userorder.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
