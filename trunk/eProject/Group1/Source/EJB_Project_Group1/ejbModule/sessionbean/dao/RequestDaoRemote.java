package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblrequest;
import entitybean.Tblservice;

@Remote
public interface RequestDaoRemote {
    public boolean add(Tblrequest request);
    
    public boolean add(Tblrequest request, List<Tblservice> listService);
    
    public Tblrequest findByID(int id);
    
    public Tblrequest findByEmail(String Email);
    
    public List<Tblrequest> getAll();
    
    public boolean update(Tblrequest updateRequest);

}
