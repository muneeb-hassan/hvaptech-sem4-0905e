package vn.edu.hungvuongaptech.bean;

import java.util.ArrayList;

import vn.edu.hungvuongaptech.dao.UserDAO;
import vn.edu.hungvuongaptech.model.UserModel;

public class UserBean {

	private ArrayList<UserModel> userModels;

	/**
	 * @return the userModels
	 */
	public ArrayList<UserModel> getUserModels() {
		ArrayList<UserModel> userModels = UserDAO.getAllUsers();
		return userModels;
	}

}
