package tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IfThen extends BodyTagSupport{
	
	IfTag parent;
    public IfThen() {
        super();
    }
    public int doStartTag() throws JspTagException {
        parent = (IfTag)findAncestorWithClass(this, IfTag.class);
        if (parent == null) {
            throw new JspTagException("Then not inside if");
        } else if (!parent.hasCondition()) {
            String warning =
                    "Condition tag must come before then tag";
            throw new JspTagException(warning);
        }
        return(EVAL_BODY_AGAIN);
    }
    public int doAfterBody() {
        IfTag parent = (IfTag)findAncestorWithClass(this, IfTag.class);
        BodyContent body = getBodyContent();
        String bodyString = body.getString();
        JspWriter out = body.getEnclosingWriter();
        try {
            if (parent.getCondition())
                out.print(body.getString());
        } catch(Exception ioe) {
            System.out.println("Error in IfElseTag: " + ioe);
        }
        return(SKIP_BODY);
    }
}
