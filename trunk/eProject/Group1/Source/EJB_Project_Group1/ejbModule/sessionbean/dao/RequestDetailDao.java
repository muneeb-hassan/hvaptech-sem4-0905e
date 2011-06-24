package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tblrequestdetail;

/**
 * Session Bean implementation class RequestDetailDao
 */
@Stateless
public class RequestDetailDao implements RequestDetailDaoRemote {
    
    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public RequestDetailDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblrequestdetail requestDetail) {
        // TODO Auto-generated method stub
        if (requestDetail == null)
            return false;
        try {
            em.persist(requestDetail);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblrequestdetail findByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tblrequestdetail> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tblrequestdetail> getListByRequestID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(Tblrequestdetail requestDetail) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Tblrequestdetail updateRequestDetail) {
        // TODO Auto-generated method stub
        return false;
    }

}
