package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblaboutus;


@Remote
public interface AboutUsDaoRemote {
    public boolean add(Tblaboutus aboutus);

    public Tblaboutus findByID(int id);

    public List<Tblaboutus> getAll();

    public boolean remove(Tblaboutus aboutus);
    
    public boolean update(Tblaboutus updateAboutus);

}
