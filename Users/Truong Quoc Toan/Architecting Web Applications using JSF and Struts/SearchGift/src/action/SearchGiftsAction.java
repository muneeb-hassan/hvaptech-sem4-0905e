package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gift;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.GiftsDAO;
import formbean.Index;

public class SearchGiftsAction extends Action {

    public SearchGiftsAction() {
        // TODO Auto-generated constructor stub
    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Index indexForm = (Index)form;
        String searchText = indexForm.getTxtSearch();
        String submitText = indexForm.getBtnSubmit();
        
//        if("List".equals(submitText)){
            try{
                GiftsDAO giftsDAO = new GiftsDAO();
                ArrayList<Gift> gifts;
                if("List".equals(submitText)){
                    gifts = giftsDAO.getAllGifts();
                }else{
                    gifts = giftsDAO.Search(searchText);
                }
                request.setAttribute("gifts", gifts);
                return mapping.findForward("success");
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
//        }else{
//            return mapping.findForward("success");
//        }
        return mapping.findForward("success");
    }

}
