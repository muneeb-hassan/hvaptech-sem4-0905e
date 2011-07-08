package payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitybean.Tblpayment;
import entitybean.Tblrequest;

import sessionbean.dao.PaymentDaoRemote;
import sessionbean.dao.RequestDaoRemote;

/**
 * Servlet implementation class payment
 */
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
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
		// TODO Auto-generated method stub
	    int requestid = 0;
	    try{
	        requestid = Integer.parseInt(request.getParameter("txtRequestID").trim());
	        if(requestid > 0){
	            BigDecimal payment = new BigDecimal(request.getParameter("txtPayment").trim());
	            String action = request.getParameter("submitPayment").trim();
	            InitialContext ctx = new InitialContext();
	            PaymentDaoRemote pDao = (PaymentDaoRemote)ctx.lookup("PaymentDao/remote");
	            RequestDaoRemote rDao = (RequestDaoRemote)ctx.lookup("RequestDao/remote");
                Tblrequest r = rDao.findByID(requestid);
	            
	            if("Insert".equals(action)){
	                Tblpayment newPayment = new Tblpayment();
	                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	                Date date = new Date();
	                String datePayment = dateFormat.format(date).toString();
	                newPayment.setDate(datePayment);
	                newPayment.setPaidamount(payment);
	                newPayment.setRequestid(r);
	                pDao.add(newPayment);
	                r.setTotalpaidamount(payment);
	                rDao.update(r);
	                rDao.updateStatusByID(r.getId(), "paymentreceived");
	            }else{
	                int paymentid = Integer.parseInt(request.getParameter("txtPaymentID").trim());
	                if(paymentid > 0){
	                    Tblpayment p = pDao.findByID(paymentid);
	                    p.setPaidamount(payment);
	                    pDao.update(p);
	                    r.setTotalpaidamount(payment);
	                    rDao.update(r);
	                }
	                
	            }
	        }
	        response.sendRedirect("admin_order_detail.jsp?requestid=" + requestid);
	    }catch (Exception e) {
            // TODO: handle exception
	        e.printStackTrace();
	        response.sendRedirect("admin_order_detail.jsp?requestid=" + requestid);
        }
	}

}
