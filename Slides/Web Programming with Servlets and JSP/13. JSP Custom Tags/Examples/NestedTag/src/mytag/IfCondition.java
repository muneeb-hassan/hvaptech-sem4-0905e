/*
 * IfCondition.java
 *
 * Created on July 30, 2007, 10:07 AM
 */

package mytag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Generated tag handler class.
 * @author  Priyabratat
 * @version
 */

public class IfCondition extends BodyTagSupport {
    
    /** Creates new instance of tag handler */
    public IfCondition() {
        super();
    }
    public int doStartTag() throws JspTagException {
        IfTag parent = ( IfTag)findAncestorWithClass(this,  IfTag.class);
        if (parent == null) {
            throw new JspTagException("condition not inside if");
        }
        return (EVAL_BODY_AGAIN);
    }
    public int doAfterBody() {
        IfTag parent = (IfTag)findAncestorWithClass(this, IfTag.class);
        BodyContent body = getBodyContent();
        String bodyString = body.getString();
        if (bodyString.trim().equals("true")) {
            parent.setCondition(true);
        } else {
            parent.setCondition(false);
        }
        return(SKIP_BODY);
    }
}

