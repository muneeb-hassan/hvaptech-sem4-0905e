package vn.edu.hungvuongaptech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import vn.edu.hungvuongaptech.common.Constant;

public class DataUtil {

	private static Connection conn = null;
	private static String URL = Constant.SETTING_RES.getString("URL");
	private static String USER = Constant.SETTING_RES.getString("USER");
	private static String PWD = Constant.SETTING_RES.getString("PWD");

	public static void connect() {
		try {
			Class.forName(Constant.SETTING_RES.getString("DRIVER"));
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void disconnected() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (conn == null)
			connect();
		return conn;
	}

	public static ResultSet executeQuery(String sql) {
		try {
			connect();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int executeUpdate(String sql) {
		try {
			connect();
			Statement statement = conn.createStatement();
			int rsUpdate = statement.executeUpdate(sql);
			return rsUpdate;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
