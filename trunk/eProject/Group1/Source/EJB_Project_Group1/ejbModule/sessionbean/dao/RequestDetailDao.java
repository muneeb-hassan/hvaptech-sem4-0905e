package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblrequestdetail.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblrequestdetail> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblrequestdetail requestDetail")
                    .getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblrequestdetail> getListRequestDetailsByRequestID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            String sqlString = "select * from tblRequestDetail where RequestID = ?";
            Query query = em.createNativeQuery(sqlString,
                    Tblrequestdetail.class);
            query.setParameter(1, id);
            List<Tblrequestdetail> list = (List<Tblrequestdetail>) query
                    .getResultList();
            //          if (list == null || list.size() <= 0)
            //              return null;
            //          return list.get(0);
            return list;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return false;
        try {
            Tblrequestdetail requestDetail = em
                    .find(Tblrequestdetail.class, id);
            if (requestDetail == null)
                return false;

            em.remove(requestDetail);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Tblrequestdetail requestDetail) {
        // TODO Auto-generated method stub
        if (requestDetail == null)
            return false;
        try {
            em.remove(requestDetail);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblrequestdetail updateRequestDetail) {
        // TODO Auto-generated method stub
        return false;
    }

}
