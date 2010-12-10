package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import util.LogUtil;

/**
 * Servlet implementation class DisplayError
 */
public class DisplayError extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerInfo = Logger.getLogger("LogINFO");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LogUtil.logInfo(loggerInfo, "404");
		PrintWriter out = response.getWriter();
		out.println("The website is maintained!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
