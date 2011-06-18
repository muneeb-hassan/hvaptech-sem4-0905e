package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblfeedback;


@Remote
public interface FeedBackDaoRemote {
    public boolean add(Tblfeedback feedback);

    public Tblfeedback findByID(int id);

    public List<Tblfeedback> getAll();

    public boolean remove(Tblfeedback feedback);
    
    public boolean update(Tblfeedback updateFeedback);

}
