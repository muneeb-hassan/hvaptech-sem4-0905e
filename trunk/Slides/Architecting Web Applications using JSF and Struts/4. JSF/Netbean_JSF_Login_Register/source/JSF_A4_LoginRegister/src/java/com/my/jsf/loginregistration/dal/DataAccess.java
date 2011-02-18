package com.my.jsf.loginregistration.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Leung
 */
public class DataAccess {

    private static Connection conn = null;

    private static void connect() {
        try {
            Context ctx = new InitialContext();
            if (ctx != null) {
                Context envContext = (Context) ctx.lookup("java:/comp/env");
                if (envContext != null) {
                    DataSource ds = (DataSource) envContext.lookup("jdbc/sqlserver");
                    if (ds != null) {
                        conn = ds.getConnection();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Could not connect to DB: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    public static Connection getConnection() {
        if (conn == null ) {
            connect();
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
            }
        }
    }

    public static ResultSet executeQuery(CallableStatement cstm) {
        try {
            if (conn == null) {
                connect();
            }
            ResultSet rs = cstm.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet executeQuery(String sql) {
        try {
            if (conn == null) {
                connect();
            }
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
            if (conn == null) {
                connect();
            }
            Statement statement = conn.createStatement();
            int n = statement.executeUpdate(sql);
            return n;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
