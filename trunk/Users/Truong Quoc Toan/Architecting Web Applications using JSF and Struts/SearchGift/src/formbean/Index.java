package formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class Index extends ActionForm {

    public Index() {
        // TODO Auto-generated constructor stub
    }
    
    private String txtSearch;
    private String btnSubmit;
    
    public String getTxtSearch() {
        return txtSearch;
    }
    public void setTxtSearch(String txtSearch) {
        this.txtSearch = txtSearch;
    }
    public String getBtnSubmit() {
        return btnSubmit;
    }
    public void setBtnSubmit(String btnSubmit) {
        this.btnSubmit = btnSubmit;
    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request){
        this.txtSearch = null;
        this.btnSubmit = null;
    }

}
