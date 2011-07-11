package addtocart;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sessionbean.dao.RequestDaoRemote;
import sessionbean.dao.ServiceDaoRemote;
import sessionbean.dao.UserDetailDaoRemote;
import entitybean.Tbldomain;
import entitybean.Tblrequest;
import entitybean.Tblservice;
import entitybean.Tbluserdetail;

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
				ServiceList = (List<addtocart.getService>) session.getAttribute(sessionServiceList);
			} else {
				if (session.getAttribute(sessionServiceList) == null && ServiceList != null) {
					ServiceList.clear();
				}
			}
			if (session.getAttribute(sessionDomainList) != null) {
				DomainList = (List<addtocart.getDomain>) session.getAttribute(sessionDomainList);
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
						break;
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
						break;
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
		response.sendRedirect("userorder.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String username = session.getAttribute("useremail").toString();
		String sessionServiceList = "ServiceList" + username;
		String location =request.getParameter("location");
		String note = request.getParameter("description");
		String daterequest="";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		daterequest = dateFormat.format(date).toString();
		String status = "received";
		try{
            InitialContext context = new InitialContext();
            RequestDaoRemote getRequestDao = (RequestDaoRemote)context.lookup("RequestDao/remote");
            UserDetailDaoRemote getUserDao = (UserDetailDaoRemote)context.lookup("UserDetailDao/remote");
            ServiceDaoRemote getServiceDao = (ServiceDaoRemote)context.lookup("ServiceDao/remote");
            
            Tbluserdetail request02 = getUserDao.findByEmail(username);
            
            Tblrequest request01 = new Tblrequest();
            
            request01.setDaterequest(daterequest);
            request01.setEmail(request02);
            request01.setNote(note);
            request01.setLocation(location);
            request01.setStatus(status);
            
            List<Tblservice>lst = new ArrayList<Tblservice>();
            List<getService> addtolst = (List<addtocart.getService>)session.getAttribute(sessionServiceList);
            for(getService p:addtolst){
            	lst.add(getServiceDao.findByID(p.getIdService()));
            }
            
            getRequestDao.add(request01, lst);
            response.sendRedirect("user_order_management.jsp");
            
		}catch(Exception e){
		    e.printStackTrace();
		    response.sendRedirect("userorder.jsp");
		}
		
	}

}
