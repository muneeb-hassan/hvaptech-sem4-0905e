package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblpagecontact;


@Remote
public interface PageContactDaoRemote {
    public boolean add(Tblpagecontact pagecontact);

    public Tblpagecontact findByID(int id);

    public List<Tblpagecontact> getAll();

    public boolean remove(Tblpagecontact pagecontact);

    public boolean update(Tblpagecontact updatePagecontact);
    
}
