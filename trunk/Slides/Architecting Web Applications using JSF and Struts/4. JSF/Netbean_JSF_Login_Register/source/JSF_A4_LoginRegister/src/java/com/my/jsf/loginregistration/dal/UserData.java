/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.my.jsf.loginregistration.dal;

import java.util.Date;

/**
 *
 * @author Leung
 */
public class UserData {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private Date addedDate;

    

    public UserData() {

    }

    UserData(int userId, String userName, String password, String email, Date addedDate) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.addedDate = addedDate;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the addedDate
     */
    public Date getAddedDate() {
        return addedDate;
    }

    /**
     * @param addedDate the addedDate to set
     */
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    
}
