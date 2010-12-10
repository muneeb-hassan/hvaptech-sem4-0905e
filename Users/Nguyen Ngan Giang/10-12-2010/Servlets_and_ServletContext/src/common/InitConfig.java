package common;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.FilterChain;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import common.Constant;

public class InitConfig extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String encoding;
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		System.out.println("InitConfig is initializing...!");
		
		encoding = config.getInitParameter("requestEncoding");
		if( encoding==null ) encoding="UTF-8";		
		
		Constant.SETTING_RES = ResourceBundle.getBundle("setting");
		Constant.SQL_RES = ResourceBundle.getBundle("sql");
		System.out.println("InitConfig is initialized successfully!");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain  next)   throws IOException, ServletException
	{
		// Respect the client-specified character encoding
		// (see HTTP specification section 3.4.1)
		if(null == request.getCharacterEncoding())
			request.setCharacterEncoding(encoding);
		/** * Set the default response content type and encoding */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		next.doFilter(request, response);
	}
}
