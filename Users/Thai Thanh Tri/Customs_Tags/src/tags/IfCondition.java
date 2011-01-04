package tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IfCondition extends BodyTagSupport{
	
	public IfCondition() {
        super();
    }
	
    public int doStartTag() throws JspTagException {
        IfTag parent = ( IfTag)findAncestorWithClass(this,  IfTag.class);
        if (parent == null) {
            throw new JspTagException("Sai dieu kien roai(^^)");
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
