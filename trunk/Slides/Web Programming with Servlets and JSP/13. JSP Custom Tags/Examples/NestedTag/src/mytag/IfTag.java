/*
 * IfTag.java
 *
 * Created on July 30, 2007, 10:05 AM
 */

package mytag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Generated tag handler class.
 * @author  Priyabratat
 * @version
 */

public class IfTag extends BodyTagSupport {
    
    
    /** Creates new instance of tag handler */
    public IfTag() {
        super();
    }
    private boolean condition;
    private boolean hasCondition = false;
    public void setCondition(boolean condition) {
        this.condition = condition;
        hasCondition = true;
    }
    public boolean getCondition() {
        return(condition);
    }
    public void setHasCondition(boolean flag) {
        this.hasCondition = flag;
    }
    /** Has the condition field been explicitly set? */
    public boolean hasCondition() {
        return(hasCondition);
    }
    public int doStartTag() {
        return(EVAL_BODY_INCLUDE);
    }
}
