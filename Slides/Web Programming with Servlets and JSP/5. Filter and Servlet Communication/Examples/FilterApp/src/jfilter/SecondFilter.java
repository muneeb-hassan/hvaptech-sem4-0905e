package jfilter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class SecondFilter
 */
public class SecondFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecondFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("Call SecondFilter ....");
		// Getting submitted user name
		String userName = request.getAttribute("userName").toString();
		
		// Replace characters [+-*/] 
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(userName);
		String newUserName = m.replaceAll("");
		
		// Update the user name
		request.setAttribute("userName",newUserName);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
