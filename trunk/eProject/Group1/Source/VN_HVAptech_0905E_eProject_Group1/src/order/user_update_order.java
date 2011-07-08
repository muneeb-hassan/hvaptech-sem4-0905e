package order;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitybean.Tblrequest;

import sessionbean.dao.RequestDaoRemote;

/**
 * Servlet implementation class user_update_order
 */
public class user_update_order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_update_order() {
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
            String action = request.getParameter("submit").trim();
            String location = request.getParameter("txtLocation").trim();
            String note = request.getParameter("txtNote").trim();
            String status = "";
            InitialContext ctx = new InitialContext();
            RequestDaoRemote rDao = (RequestDaoRemote) ctx
                    .lookup("RequestDao/remote");
            Tblrequest r = rDao.findByID(requestID);
            if (r == null) {

            }
            if ("Update".equals(action)) {
                r.setLocation(location);
                r.setNote(note);
                boolean rs = rDao.update(r);
                response.sendRedirect("user_order_detail.jsp?rs=" + rs + "&requestid=" + r.getId());
            } else {
                if ("Cancel".equals(action)) {
                    status = "canceled";
                } else if ("Accept".equals(action)) {
                    status = "accepted";
                }
                boolean rs = rDao.updateStatusByID(r.getId(), status);
                response.sendRedirect("user_order_management.jsp?rs=" + rs);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}