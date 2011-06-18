package sessionbean.dao;

import java.util.List;

import javax.ejb.Remote;

import entitybean.Tbllevel;
import entitybean.Tbluserdetail;

@Remote
public interface LevelDaoRemote {
    public boolean add(Tbllevel level);

    public Tbllevel findByID(int id);

    public List<Tbllevel> getAll();

    public boolean remove(Tbllevel level);
    
    public boolean update(Tbllevel updateLevel);

    public List<Tbluserdetail> getUserDetailsByLevelID(int id);

}
