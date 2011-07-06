package domain;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbean.dao.DomainDaoRemote;
import entitybean.Tbldomain;

/**
 * Servlet implementation class addDel_Domain
 */
public class addDel_Domain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_Domain() {
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
		String domain;
		String domainid;
		String cmdCommand = request.getParameter("submit").trim();
		boolean result = false;
	
		if (request.getParameter("domain") != null && !request.getParameter("domain").isEmpty()) {
			try {
				InitialContext context = new InitialContext();
				DomainDaoRemote domainadmin = (DomainDaoRemote) context
						.lookup("DomainDao/remote");
				Tbldomain adddomain = new Tbldomain();
				domain = request.getParameter("domain").trim();
				adddomain.setDomainname(domain);

				if (cmdCommand.equals("Insert")) {
					result = domainadmin.add(adddomain);
				} else {
					domainid = request.getParameter("domainid").trim();
					adddomain.setId(Integer.parseInt(domainid));
					result = domainadmin.update(adddomain);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("domain_admin.jsp");
	}

}
