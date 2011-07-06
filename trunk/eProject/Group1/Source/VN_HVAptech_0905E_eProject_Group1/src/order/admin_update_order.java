package order;

import java.io.IOException;
import java.math.BigDecimal;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbean.dao.RequestDaoRemote;
import entitybean.Tblrequest;

/**
 * Servlet implementation class admin_update_order
 */
public class admin_update_order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_update_order() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            int requestID = Integer.parseInt(request.getParameter(
                    "txtRequestID").trim());
//            String action = request.getParameter("submit").trim();
            String totalPayment = request.getParameter("txtTotalPayment").trim();
//            String totalPaidAmount = request.getParameter("txtTotalPaidAmount").trim();
            String dateBegin = request.getParameter("txtDateBegin").trim();
            String dateComplete = request.getParameter("txtDateComplete").trim();
            String status = request.getParameter("cbxStatus").trim();;
            InitialContext ctx = new InitialContext();
            RequestDaoRemote rDao = (RequestDaoRemote) ctx
                    .lookup("RequestDao/remote");
            Tblrequest r = rDao.findByID(requestID);
            if (r == null) {

            }
//            response.getWriter().println(totalPayment);
//            response.getWriter().println(totalPaidAmount);
//            response.getWriter().println(dateBegin);
//            response.getWriter().println(dateComplete);
//            response.getWriter().println(status);
            r.setTotalpayment(new BigDecimal(totalPayment));
//            r.setTotalpaidamount(new BigDecimal(totalPaidAmount));
            r.setDatebegin(dateBegin);
            r.setDatecomplete(dateComplete);
            r.setStatus(status);
            
            boolean rs = false;
            
            rs = rDao.update(r);
            
            rs = rDao.updateStatusByID(r.getId(), status);
            
            response.sendRedirect("admin_order_detail.jsp?rs=" + rs + "&requestid=" + r.getId());
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
