/**
 *
 */
package vn.edu.hungvuongaptech.common;

import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 * @author ThanhHQ
 *
 */
public class InitConfig extends HttpServlet {

	private static final long serialVersionUID = 1L;


	/*
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("----- InitConfig is initializing...! -----");
		Constant.SETTING_RES = ResourceBundle.getBundle("setting");
		System.out.println("----- InitConfig is initialized successfully! -----");
	}

}
