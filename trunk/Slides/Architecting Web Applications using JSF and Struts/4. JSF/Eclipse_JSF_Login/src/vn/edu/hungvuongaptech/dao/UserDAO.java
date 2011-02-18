package vn.edu.hungvuongaptech.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.edu.hungvuongaptech.model.UserModel;
import vn.edu.hungvuongaptech.util.DataUtil;

public class UserDAO {

	public static UserModel getUserByUsernameAndPassword(String username, String password) {
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement("SELECT UserID, Username FROM Users WHERE Username = ? AND Password = HashBytes('MD5', ?)");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			UserModel userModel = new UserModel();
			if (rs.next()) {
				userModel.setUserId(rs.getInt("UserID"));
				userModel.setUsername(rs.getString("Username"));
				return userModel;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int createUser(String username, String password, String email, String address, String classname) {
		int count = 0;
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement("INSERT INTO [Users] (Username, Password, Email, Address, Class) VALUES (?, HashBytes('MD5', ?), ?, ?, ?)");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, address);
			statement.setString(5, classname);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static ArrayList<UserModel> getAllUsers() {
		ArrayList<UserModel> userModels = new ArrayList<UserModel>();
		try {
			PreparedStatement statement = DataUtil.getConnection().prepareStatement("SELECT UserID, Username, Email, Address, Class FROM Users");
			ResultSet rs = statement.executeQuery();
			UserModel userModel = null;
			while (rs.next()) {
				userModel = new UserModel();
				userModel.setUserId(rs.getInt("UserID"));
				userModel.setUsername(rs.getString("Username"));
				userModel.setEmail(rs.getString("Email"));
				userModel.setAddress(rs.getString("Address"));
				userModel.setClassname(rs.getString("Class"));
				userModels.add(userModel);
			}
			return userModels;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}