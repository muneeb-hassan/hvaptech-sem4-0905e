/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.jsf.loginregistration.dal;

import com.my.jsf.loginregistration.dal.DataAccess;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 *
 * @author Leung
 */
public class UserDAO {

    public static UserData login(String userName, String password) {
        UserData user = null;
        Connection conn = DataAccess.getConnection();
        try {
            CallableStatement cstm = conn.prepareCall("{ Call usp_UsersLogin(?,?) }");
            cstm.setString("userName", userName);
            cstm.setString("pass", password);
            ResultSet rs = DataAccess.executeQuery(cstm);
            if (rs.next()) {
                user = new UserData();
                user.setUserId(rs.getInt("UserId"));
                user.setUserName(rs.getString("UserName"));
                user.setEmail(rs.getString("Email"));
                user.setAddedDate(rs.getDate("AddedDate"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataAccess.closeConnection();
        }

        return user;
    }

    public static int register(String userName, String password, String email) {
        int newUserId = 0;

        Connection conn = DataAccess.getConnection();
        try {
            CallableStatement cstm = conn.prepareCall("{ Call usp_UsersInsert (?,?,?) }");

            cstm.setString("userName", userName);
            cstm.setString("password", password);
            cstm.setString("email", email);

            ResultSet rs = DataAccess.executeQuery(cstm);
            rs.next();
            newUserId = rs.getInt("UserId");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataAccess.closeConnection();
        }
        return newUserId;
    }

    public static List selectAllUser() {
        ArrayList<UserData> users = new ArrayList<UserData>();

        Connection conn = DataAccess.getConnection();
        try {
            CallableStatement cstm = conn.prepareCall("{ Call usp_UsersSelect }");
            ResultSet rs = DataAccess.executeQuery(cstm);
            while(rs.next()){
                UserData user = new UserData();
                user.setUserId(rs.getInt("UserId"));
                user.setUserName(rs.getString("UserName"));
                user.setEmail(rs.getString("Email"));
                user.setAddedDate(rs.getDate("AddedDate"));
                users.add(user);
            }
        }  catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataAccess.closeConnection();
        }
        return users;
    }
}
