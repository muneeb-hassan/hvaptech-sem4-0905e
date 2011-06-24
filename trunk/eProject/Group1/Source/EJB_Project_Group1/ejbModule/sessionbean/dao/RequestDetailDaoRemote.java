package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblrequestdetail;

@Remote
public interface RequestDetailDaoRemote {
    public boolean add(Tblrequestdetail requestDetail);
    
    public Tblrequestdetail findByID(int id);

    public List<Tblrequestdetail> getAll();
    
    public List<Tblrequestdetail> getListByRequestID(int id);

    public boolean remove(int id);
    
    public boolean remove(Tblrequestdetail requestDetail);
    
    public boolean update(Tblrequestdetail updateRequestDetail);

}
