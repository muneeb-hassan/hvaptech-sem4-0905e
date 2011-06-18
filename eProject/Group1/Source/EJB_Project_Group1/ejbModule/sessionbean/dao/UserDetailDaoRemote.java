package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tbllevel;
import entitybean.Tbluserdetail;


@Remote
public interface UserDetailDaoRemote {
    public boolean add(Tbluserdetail userdetail);

    public Tbluserdetail findByID(int id);
    
    public Tbluserdetail findByEmailAndPassword(String email, String password);

    public List<Tbluserdetail> getAll();

    public boolean remove(Tbluserdetail userdetail);

    public boolean update(Tbluserdetail updateUserdetail);

    public Tbllevel getLevelByUserID(int id);

}
