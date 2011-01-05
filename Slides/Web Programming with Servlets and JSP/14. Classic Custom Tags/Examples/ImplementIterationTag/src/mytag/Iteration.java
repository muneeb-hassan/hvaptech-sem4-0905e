/*
 *Iteration.java
 *This program creates the tag handler class for a classic custom tag
 *that needs to act iteratively.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package mytag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

/**
 * Iteration class defines the functionality of a classic custom tag.
 * The number of iteration for the tag is passed to the tag as an attribute.
 *
 * @author vincent
 */

public class Iteration implements IterationTag  {
    // The fields pageContext, parent, count and bodyContent are declared.
    private PageContext pageContext;
    private Tag parent;
    int count = 0;
    BodyContent bodyContent;
    /** Creates new instance of tag handler */
    public Iteration() {
        super();
    }
    // The object bodyContent is set
    public void setBodyContent(BodyContent bodyContent) {
        //The bodyContent object is assigned the passed value.
        this.bodyContent = bodyContent;
    }
    //The object count is set here.
    public void setCount(int count) {
        //The object, count is assigned a passed value.
        this.count = count;
    }
    public int doAfterBody() throws JspException {
        System.out.println("doAfterBody()");
        //if condition is tested for count
        if (count>1) {
            count--;
            // This statement forces the doStartTag() method to reinvoke
            return EVAL_BODY_AGAIN;
        } else {
            //This statement allows skipping the body inside the tag
            return SKIP_BODY;
        }
    }
    
    public void setPageContext(PageContext pc) {
        //The object, pageContext is assigned the passed value.
        this.pageContext = pageContext;
    }
    
    public void setParent(Tag t) {
        //The object, parent is assigned the passed value.
        this.parent = parent;
    }
    
    public Tag getParent() {
        return parent;
    }
    
    public int doStartTag() throws JspException {
        System.out.println("doStartTag()");
        //if condition is tested for count
        if (count >0) {
//This statement will invoke doAfterBody() method.
            return EVAL_BODY_INCLUDE;
        } else {
// This statement will let the method skip the body.
            return SKIP_BODY;
        }
    }
    
    public int doEndTag() throws JspException {
        System.out.println("doEndTag()");
        try {
            //if condition is tested for bodyContent.
            if(bodyContent != null) {
                // The value of the bodyContent is written into writeOut object.
                bodyContent.writeOut(bodyContent.getEnclosingWriter());
            }
        } catch(IOException e) {
            throw new JspException("Error: "+e.getMessage());
        }
        //The EVAL_PAGE constant is returned to allow the container to evaluate
        //the rest of the JSP page.
        return EVAL_PAGE;
    }
    
    public void release() {
        System.out.println("release()");
    }
    
}
