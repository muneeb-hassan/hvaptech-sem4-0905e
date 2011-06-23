package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tbldomain;
import entitybean.Tblservice;


@Remote
public interface ServiceDaoRemote {
    public boolean add(Tblservice service);

    public Tblservice findByID(int id);

    public List<Tblservice> getAll();

    public boolean remove(int id);
    
    public boolean remove(Tblservice service);
    
    public boolean update(Tblservice updateService);

    public Tbldomain getDomainByServiceID(int id);

}
