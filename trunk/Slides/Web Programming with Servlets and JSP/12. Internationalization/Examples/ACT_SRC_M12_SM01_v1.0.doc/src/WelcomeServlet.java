/*
 * ResourceBundle.jsp
 *
 * This program uses resource bundling for internationalization of servlets.
 *  
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
   

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*  @author vincent
 */

/* WelcomeServlet class get the client's locale and display locale */  
public class WelcomeServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
        //Get the client's Locale
        Locale locale = request.getLocale();
        
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.WelcomeBundle",locale);
        
        String welcome = bundle.getString("Welcome");
        
        //Display the locale
        response.setContentType(java.util.ResourceBundle.getBundle("input_de").getString("text/html"));
        java.io.PrintWriter out = response.getWriter();
        
        out.println(java.util.ResourceBundle.getBundle("input_de").getString("<html><head><title>") + welcome + java.util.ResourceBundle.getBundle("input_de").getString("</title></head><body>"));
        
        out.println(java.util.ResourceBundle.getBundle("input_de").getString("<h2>") + welcome + java.util.ResourceBundle.getBundle("input_de").getString("</h2>"));
        
        out.println(java.util.ResourceBundle.getBundle("input_de").getString("Locale:_"));
        out.println(locale.getLanguage() + java.util.ResourceBundle.getBundle("input_de").getString("_") + locale.getCountry());
        
        out.println(java.util.ResourceBundle.getBundle("input_de").getString("</body></html>"));
        out.close();
        
    } //end doGet
    
    // doPost method ...
    
}//WelcomeServlet
