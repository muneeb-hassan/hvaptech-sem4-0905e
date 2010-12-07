
/* SessionListen.java */
/*
 * This program creates servlet program that uses the SessionEvent class for session event handling.
 *
 *Copyright © 2007 Aptech Software Limited. All rights reserved.
 *
*/
package servlet;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/* 
 * @author Vincent
 * 
 */
/* SessionListen class allows session event handling */
public class SessionListen implements HttpSessionListener {
/* Declaring the integer sessioncount */    
    private int sessionCount;
    
  /* Initializing sessionCount in SessionListen */  
    public SessionListen() {
        this.sessionCount = 0;
    }
   /*Notification about session creation where se is event */   
    public void sessionCreated(HttpSessionEvent se) {
        
   /*Return the current session and if one does not exist, 
    a new session will be cretaed.*/      
        HttpSession session = se.getSession();
      /*Sets maximum inactive inetrval for the session*/   
        session.setMaxInactiveInterval(60);
        synchronized (this) {
            sessionCount++;
        }
      /* Assigns session ID to string varialble */  
        String id = session.getId();
        
        /* Assigns date*/  
        Date now = new Date();
        
     /* Displays message in string format by appending "id" and "sessionCount" */     
        String message = new StringBuffer("New Session created on ").append(
                now.toString()).append("\nID: ").append(id).append("\n")
                .append("There are now ").append("" + sessionCount).append(
                " live sessions in the application.").toString();
        
        System.out.println(message);
    }
   /*Notification about session destruction where se is event */ 
    public void sessionDestroyed(HttpSessionEvent se) {
        
        HttpSession session = se.getSession();
        String id = session.getId();
        synchronized (this) {
            --sessionCount;
        }
        String message = new StringBuffer("Session destroyed"
                + "\nValue of destroyed session ID is").append("" + id).append(
                "\n").append("There are now ").append("" + sessionCount)
                .append(" live sessions in the application.").toString();
        System.out.println(message);
    }
}
