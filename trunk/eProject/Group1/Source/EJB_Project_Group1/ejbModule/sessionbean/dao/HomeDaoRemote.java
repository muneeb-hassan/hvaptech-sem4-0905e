package sessionbean.dao;

import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblhome;


@Remote
public interface HomeDaoRemote {
    public boolean add(Tblhome home);

    public Tblhome findByID(int id);

    public List<Tblhome> getAll();

    public boolean remove(int id);
    
    public boolean remove(Tblhome home);

    public boolean update(Tblhome updateHome);

}
