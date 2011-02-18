package vn.edu.hungvuongaptech.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import vn.edu.hungvuongaptech.dao.UserDAO;
import vn.edu.hungvuongaptech.model.UserModel;

public class LoginBean {

	private String username;
	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Login action.
	 */
	public String action() {
		try {
			UserModel userModel = UserDAO.getUserByUsernameAndPassword(username, password);
			if (userModel != null) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid", userModel.getUserId());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", userModel.getUsername());
				return "loginSuccess";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username and password!", "Invalid username and password!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "loginFailure";
	}
}
