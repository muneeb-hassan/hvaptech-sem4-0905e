package faq;

import java.io.IOException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitybean.Tblfaq;

import sessionbean.dao.FaqDaoRemote;

/**
 * Servlet implementation class addDel_faq
 */
public class addDel_faq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDel_faq() {
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
			int faqId = Integer.parseInt(request.getParameter("ID"));
			try {
				InitialContext context = new InitialContext();
				FaqDaoRemote beanRemote = (FaqDaoRemote)context.lookup("FaqDao/remote");
				getresult = beanRemote.remove(faqId);		
			} catch (NamingException e) {
				getresult = false;
			}
		}
		if(getresult == false){
			request.setAttribute("result", "Delete false");
		}else{
			request.setAttribute("result", "Delete sucess");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("faq_admin02.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmdCommand = request.getParameter("submit");
		String question = request.getParameter("question");
		String answer = request.getParameter("editor1");
		String faqID = "";
		
		if(request.getParameter("faqID") != null){
			faqID = request.getParameter("faqID");
		}
		
		boolean result = false;
		try {
			InitialContext context = new InitialContext();
			FaqDaoRemote beanRemote = (FaqDaoRemote)context.lookup("FaqDao/remote");
			Tblfaq addfaq = new Tblfaq();
			addfaq.setAnswer(answer);
			addfaq.setQuestion(question);
			if(cmdCommand == "Insert"){
				result = beanRemote.add(addfaq);
			}else{
				addfaq.setId(Integer.parseInt(faqID));
				result = beanRemote.update(addfaq);
			}
				
		} catch (NamingException e) {
			e.printStackTrace();
		}					
		response.sendRedirect("faq_admin02.jsp");
	}

}
