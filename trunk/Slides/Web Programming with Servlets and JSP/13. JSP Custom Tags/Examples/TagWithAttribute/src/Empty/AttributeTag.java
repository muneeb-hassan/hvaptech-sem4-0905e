/*
 * AttributeTag.java
 *This program demonstrates creating tag handler class for a 
 *custom tag with attributes.
 *Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package Empty;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

/**
 * AttributeTag class allows user to create a custom tag that passes attribute
 * in to the JSP page.
 *
 * @author vincent
 */

public class AttributeTag extends TagSupport {
    //A variable name of  data type String is declared as private
    private String name;
    //A string argument “name” is passed to the method.
    public void setName(String name){
        // The variable name is set the passed String value
        this.name = name;
    }
    
    /** Creates new instance of tag handler */
    public AttributeTag() {
        super();
    }
    // The getName() method returns the value of name
    public String getName(String name){
        return name;
    }
    // The doStartTag() method is called here
    public int doStartTag() throws JspException {
        try {
            //This statement prints a string
            pageContext.getOut().print("This is a JSP Program of " +
                    "Custom Tag with : " + name);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //The SKIP_BODY constant is returned
        return SKIP_BODY;
    }
    //The doEndTag() is called with here 
   public int doEndTag() throws JspException {
       //The SKIP_PAGE constant is returned
       return SKIP_PAGE;
   }
}
