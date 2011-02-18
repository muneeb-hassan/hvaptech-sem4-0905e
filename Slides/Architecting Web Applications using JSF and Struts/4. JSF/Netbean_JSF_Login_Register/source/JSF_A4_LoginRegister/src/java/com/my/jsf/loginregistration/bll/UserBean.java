/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.jsf.loginregistration.bll;

import com.my.jsf.loginregistration.dal.UserDAO;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Leung
 */
public class UserBean {

    private int userId;
    private String userName;
    private String password;
    private String email;
    private Date addedDate;
    private List users;
    private ListDataModel usersDataModel = new ListDataModel();

    public UserBean(){}

    public UserBean(int userId, String userName, String password, String email, Date addedDate) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.addedDate = addedDate;
    }

    public String registerNewUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        int newUserId = UserDAO.register(userName,password,email);

        if ( newUserId == 0 ){
             context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Registration did failure.",""));
            return "failure";
        }else{
            return "success";
        }

    }

    // <editor-fold defaultstate="collapsed" desc="properties">
    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
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
     * @return the addedDate
     */
    public Date getAddedDate() {
        return addedDate;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param addedDate the addedDate to set
     */
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }// </editor-fold>

    public ListDataModel getUsers() {
        users = UserDAO.selectAllUser();
        usersDataModel.setWrappedData(users);

        return usersDataModel;
    }

}
