/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.my.jsf.loginregistration.bll;

import com.my.jsf.loginregistration.dal.UserDAO;
import com.my.jsf.loginregistration.dal.UserData;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leung
 */
public class AuthenticationBean {
    private String userName;
    private String password;

    public AuthenticationBean(){}

    public String login(){
        FacesContext context = FacesContext.getCurrentInstance();
        // validate user
         UserData user = UserDAO.login(userName,password);
         if(user == null){
            context.addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Incorrect UserName or Password.",""));
            return "failure";
         }
         else {
            context.getExternalContext().getSessionMap().
                                            put("user", user);
            return "success";
         }         
    }

    // <editor-fold defaultstate="collapsed" desc="Properties">

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

   // </editor-fold>
    
}
