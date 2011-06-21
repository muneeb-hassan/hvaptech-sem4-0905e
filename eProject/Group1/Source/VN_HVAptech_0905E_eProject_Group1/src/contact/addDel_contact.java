package contact;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbean.dao.PageContactDaoRemote;
import entitybean.Tblpagecontact;

/**
 * Servlet implementation class addDel_contact
 */
public class addDel_contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_contact() {
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
		
		String cmdCommand = request.getParameter("submit");
		String contactdetail = request.getParameter("editor1");
		String ContactID = "";
		
		if(request.getParameter("ContactID") != null){
			ContactID = request.getParameter("ContactID");
		}
		
		boolean result = false;
		try {
			InitialContext context = new InitialContext();
			PageContactDaoRemote contactAdmin = (PageContactDaoRemote)context.lookup("PageContactDao/remote");
			Tblpagecontact addcontact = new Tblpagecontact();
			addcontact.setIntrodution(contactdetail);
			if(cmdCommand == "Insert"){
				result = contactAdmin.add(addcontact);
			}else{
				addcontact.setId(Integer.parseInt(ContactID));
				result = contactAdmin.update(addcontact);
			}
				
		} catch (NamingException e) {
			e.printStackTrace();
		}					
		response.sendRedirect("contact_admin02.jsp");
	}

}
