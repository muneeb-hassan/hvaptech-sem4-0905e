/*
 * Interface.java
 *
 * This program represents the tag handler class of a classic custom tag that 
 *implements BodyTag interface. The custom tag has body and it needs to
 *manipulate it.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 *
 */

package mytag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;
/**
 * Interface class allows user to craete a custom tag that 
 * manipulate its body.
 *
 * @author vincent
 */

public class Interface implements BodyTag{
    //The fields of type BodyContent, PageContext, Tag and count are
    //declared here.
    private BodyContent b;
    private PageContext pc;
    private Tag t;
    int count = 0;
    /** Creates new instance of tag handler */
    public Interface() {
        super();
    }
    // The value of the count is set.
    public void setCount(int count) {
        // count is assigned the passed value.
        this.count = count;
    }
    
    public void setBodyContent(BodyContent b) {
        System.out.println("setBodyContent()");
        //b is assigned the passed value.
        this.b=b;
    }
    
    public void doInitBody() throws JspException {
        System.out.println("doInitBody()");
    }
    
    public int doAfterBody() throws JspException {
        System.out.println("doAfterBody()");
        //The count value is decreased till the if condition satisfies
        if (count>1) {
            //count is decreased gradually.
            count--;
            //This reinvokes the doStartTag() method if the body
            //needs to be reevaluated.
            return EVAL_BODY_AGAIN;
        }
        //When the if condition dose not satisfy!!
        else {
            // This statement will let the method skip the body
            return SKIP_BODY;
        }
    }
    
    public void setPageContext(PageContext pc) {
        //The current value of the PageContext is assigned to pc.
        this.pc=pc;
    }
    
    public void setParent(Tag t) {
        //The current value of the Parent is assigned to t.
        this.t=t;
    }
    
    public Tag getParent() {
        // The value of parent is returned.
        return t;
    }
    
    public int doStartTag() throws JspException {
        System.out.println("doStartTag()");
        //if condition is tested for count.
        if (count >0) {
            //This statement will invoke doAfterBody() method.
            return EVAL_BODY_INCLUDE;
        }
        //When the  if condition dose not satisfy!!
        else {
            // This statement will let the method skip the body.
            return SKIP_BODY;
        }
    }
    
    public int doEndTag() throws JspException {
        System.out.println("doEndTag()");
        try {
            //if condition is tested for the value of b.
            if(b != null) {
                //The  string b is written to writeOut object.
                b.writeOut(b.getEnclosingWriter());
            }
        } catch(IOException e) {
            throw new JspException("Error: "+e.getMessage());
        }
        // The return statement let the rest of the JSP page evaluated.
        return EVAL_PAGE;        
    }
    
    public void release() {
        System.out.println("release()");
    }
}
