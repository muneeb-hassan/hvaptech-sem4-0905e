package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tbldomain;
import entitybean.Tblservice;

@Remote
public interface DomainDaoRemote {
    public boolean add(Tbldomain domain);

    public Tbldomain findByID(int id);

    public List<Tbldomain> getAll();

    public boolean remove(Tbldomain domain);
    
    public boolean update(Tbldomain updateDomain);

    public List<Tblservice> getServicesByDomainID(int id);

}
