/*
 * SimpServlet.java
 *
 * This program creates a simple servlet to access the context object
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package servlet;

import java.io.*;
import java.util.Date;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
/** SimpServlet class creates a servlet to access the context object
 *
 * @author vincent
 */
public class SimpServlet extends HttpServlet {
    public void init(ServletConfig cnf) throws ServletException {
        super.init(cnf);
        ServletContext cnt=cnf.getServletContext();
        ContextObject obj = new ContextObject();
        obj.startTimeStamp();
        cnt.setAttribute("obj",obj);
        System.out.println("ContextObject Servlet.init()");
    }
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=us-ascii");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>");
        out.println("ContextObject");
        out.println("</TITLE></HEAD>");
        out.println("");
        out.println("<BODY>");
        out.println("<CENTER>");
        ServletContext cnt=getServletContext();
        Object cobj=cnt.getAttribute("obj");
        if(cobj!=null) {
            ContextObject obj=(ContextObject)cobj;
            obj.time();
            List list1=obj.getTime();
            writeTimeTable(out,list1);
        } else {
            out.println("ContextObject not found!");
        }
        out.println("</CENTER>");
        out.println("</BODY></HTML>");
    }
    public void destroy() {
        ServletContext cnt=getServletContext();
        Object cobj=cnt.getAttribute("obj");
        if(cobj!=null) {
            ContextObject obj=(ContextObject)cobj;
            obj.stopTimeStamp();
            cnt.removeAttribute("obj");
        }
        System.out.println("ContextObjectServlet.destroy()");
    }
    private void writeTimeTable(PrintWriter out, List list1) {
        int size=list1.size();
        if(size!=0) {
            out.println("<TABLE BODER=\"1\">");
            out.println("<TR><TH>Count</TH><TH>Time</TH></TR>");
            for(int i=0;i<size;i++) {
                out.println("<TR>");
                out.println("<TD>");
                out.println((i+1)+" time");
                out.println("</TD>");
                out.println("<TD>");
                out.println(((Date)list1.get(i)).toString());
                out.println("</TD>");
                out.println("</TR>");
            }
            out.println("</TABLE>");
        } else {
            out.println("No timestamp!");
        }
    }
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Version 1.0, written by Vincent";
    }
}