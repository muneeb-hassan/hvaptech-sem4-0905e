package vn.edu.hungvuongaptech.bean;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import vn.edu.hungvuongaptech.dao.UserDAO;

public class RegisterBean {

	private String username;
	private String password;
	private String email;
	private String address;
	private String classname;

	public String registerAction() {
		int count = UserDAO.createUser(username, password, email, address, classname);
		if (count > 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Register successfully! Login now!", "Register successfully! Login now!");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "registerSuccess";
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to register! Please try again!", "Unable to register! Please try again!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "registerFailure";
	}
	
	public void validateUsername(FacesContext context, UIComponent component, Object value) {
		String newValue = (String) value;
		Pattern mask = Pattern.compile("^[a-zA-Z0-9_@.]{5,100}");
		if (!mask.matcher(newValue).matches()) {
			((UIInput) component).setValid(false);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username!", "Invalid username!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void validatePassword(FacesContext context, UIComponent component, Object value) {
        String newValue = (String) value;
        if (newValue == null || newValue.length() < 5) {
            ((UIInput) component).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid password!", "Invalid password!");
			FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	
	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) {
        String email = (String) value;
        Pattern mask = Pattern.compile("^([\\w-\\.])+@([\\w])+\\.(\\w){2,6}(\\.([\\w]){2,4})*$");
        if (!mask.matcher(email).matches()) {
            ((UIInput)toValidate).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid email!", "Invalid email!");
			FacesContext.getCurrentInstance().addMessage(null, message);
        }   
    }
	
	public void validateAddress(FacesContext context, UIComponent component, Object value) {
        String newValue = (String) value;
        if (newValue == null || newValue.length() < 5) {
            ((UIInput) component).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid address!", "Invalid address!");
			FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	
	public void validateClass(FacesContext context, UIComponent component, Object value) {
        String newValue = (String) value;
        if (newValue == null || newValue.length() < 6) {
            ((UIInput) component).setValid(false);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid class!", "Invalid class!");
			FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param classname
	 *            the classname to set
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}

}
