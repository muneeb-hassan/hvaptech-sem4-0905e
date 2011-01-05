/*
 * EmptyTag.java
 *This program demonstrates creating a tag handler by extending to the TagSupport 
 *class for a classic custom tag that is without any body.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package empty;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

/**
 *EmptyTag class allows user to define a classic custom tag by implementing
 * TagSupport interface. A string will be passed to the calling JSP page through 
 * the custom tag.
 *
 * @author Vincent
 */

public class EmptyTag extends TagSupport  {
    
    /** Creates new instance of tag handler */
    public EmptyTag() {
        super();
    }
    //The starting end of the custom tag is encountered
    public int doStartTag() throws JspException {
        try {
            //The current value of pageContext is printed
            pageContext.getOut().print("This is my first tag!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //This is returned if the tag body is empty
        return SKIP_BODY;
    }
    //The finishing end of the custom tag is encountered
    public int doEndTag() throws JspException {
        //This is returned if the rest of the page is not suppose to be evaluated
        return SKIP_PAGE;
    }
}
