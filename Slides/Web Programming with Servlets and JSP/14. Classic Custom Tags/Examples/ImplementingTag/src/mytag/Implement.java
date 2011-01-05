/*
 * Implement.java
 *This program demonstrates creating a tag handler for a classic custom tag that
 *is without any body.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 *
 */

package mytag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;


/**
 * Implement class allows user to define a classic custom tag by implementing
 * Tag interface.
 *
 * @author Vincent
 */

public class Implement implements Tag {
    //The Fields, pageContext and parent are declared
    private PageContext pageContext;
    private Tag parent;
    /** Creates new instance of tag handler */
    public Implement() {
        super();
    }
    
    public void setPageContext(PageContext pageContext) {
        //The current value of the pageContext is set
        this.pageContext = pageContext;
    }
    
    public void setParent(Tag tag) {
        //The current value of the parent is set
        this.parent = tag;
    }
    
    public Tag getParent() {
        //The value of parent is returned
        return parent;
    }
    
    public int doStartTag() throws JspException {
        try {
            //This statement prints the string value of the pageContext
            pageContext.getOut().print("Craeting Custom Tag by Implementing Tag Interface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // The SKIP_BODY is returned
        return SKIP_BODY;
    }
    
    public int doEndTag() throws JspException {
        // the SKIP_PAGE is returned
        return SKIP_PAGE;
    }
    
    public void release() {
    }
}
