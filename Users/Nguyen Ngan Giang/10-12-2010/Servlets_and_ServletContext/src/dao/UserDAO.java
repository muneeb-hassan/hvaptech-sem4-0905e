package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import model.StudentLoginModel;
import model.StudentModel;
import common.Constant;
import util.DataUtil;
import util.LogUtil;

public class UserDAO {
	
	private static final Logger logger = Logger.getLogger(DataUtil.class.getName());
	
	public static StudentLoginModel userDetails(String studentID){
		StudentLoginModel studentLoginModel = new StudentLoginModel();
		try {
			PreparedStatement preparedStatement = DataUtil.getConnection().prepareStatement(Constant.SQL_RES.getString("getStudentLogin"));
			preparedStatement.setString(1, studentID);			
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				studentLoginModel.setStudentID(rs.getString("StudentID"));
				studentLoginModel.setPassword(rs.getString("Password"));
			}
		} catch (SQLException e) {
			LogUtil.logError(e, logger);
		}
		return studentLoginModel;
	}
	
	public static StudentModel getStudentByStudentID(String studentID){
		StudentModel studentModel = new StudentModel();
		try {
			PreparedStatement preparedStatement = DataUtil.getConnection().prepareStatement(Constant.SQL_RES.getString("getStudentByStudentID"));
			preparedStatement.setString(1, studentID);			
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				studentModel.setStudentID (rs.getString("StudentID"));
				studentModel.setStudentName(rs.getString("StudentName"));
				studentModel.setDateBirth(rs.getString("DateBirth"));
			}
		} catch (SQLException e) {
			LogUtil.logError(e, logger);
		}
		return studentModel;
	}
}
