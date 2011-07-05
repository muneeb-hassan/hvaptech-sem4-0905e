package feedback;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sessionbean.dao.FaqDaoRemote;
import sessionbean.dao.FeedBackDaoRemote;
import entitybean.Tblfeedback;

/**
 * Servlet implementation class addDel_feedback
 */
public class addDel_feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_feedback() {
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
			int Id = Integer.parseInt(request.getParameter("ID"));
			try {
				InitialContext context = new InitialContext();
				FeedBackDaoRemote delfeedback = (FeedBackDaoRemote)context.lookup("FeedBackDao/remote");
				getresult = delfeedback.remove(Id);	
			} catch (NamingException e) {
				getresult = false;
			}
		}
		if(getresult == false){
			request.setAttribute("result", "Delete false");
		}else{
			request.setAttribute("result", "Delete sucess");
		}
		response.sendRedirect("feedback_admin02.jsp");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname").trim();
		String email = request.getParameter("email").trim();
		String comment = request.getParameter("feedback").trim();
		String messageFeedback="";
		boolean result = false;
		try{
			InitialContext context = new InitialContext();
			FeedBackDaoRemote addfeedback = (FeedBackDaoRemote)context.lookup("FeedBackDao/remote");
			
			Tblfeedback feedback = new Tblfeedback();
			feedback.setComment(comment);
			feedback.setEmail(email);
			feedback.setFullname(fullname);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			feedback.setDatecreate(dateFormat.format(date));
			addfeedback.add(feedback);
			result = true;
			messageFeedback = "Thank you for your comment.";
		}catch(Exception e){
			messageFeedback = "Sorry. System error. Please come back again.";
		}
		HttpSession session = request.getSession();
		session.setAttribute("messageFeedback", messageFeedback);
		response.sendRedirect("feedback.jsp");
	}

}
