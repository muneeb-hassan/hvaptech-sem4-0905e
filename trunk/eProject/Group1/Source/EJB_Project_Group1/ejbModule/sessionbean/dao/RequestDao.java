package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tblrequest;
import entitybean.Tblrequestdetail;
import entitybean.Tblservice;

/**
 * Session Bean implementation class RequestDao
 */
@Stateless
public class RequestDao implements RequestDaoRemote {
    
    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public RequestDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblrequest request) {
        // TODO Auto-generated method stub
        if (request == null)
            return false;
        try {
            em.persist(request);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(Tblrequest request, List<Tblservice> listService) {
        // TODO Auto-generated method stub
        if (request == null)
            return false;
        try {
            em.persist(request);
//            int requestID = Integer.parseInt(em.createQuery(
//                    "select max(request.id) from Tblrequest as request")
//                    .getSingleResult().toString().trim());
//            Tblrequest newRequest = this.findByID(requestID);
            RequestDetailDao rDetailDao = new RequestDetailDao();
            rDetailDao.setEm(em);
            Tblrequestdetail rDetail;
            for (Tblservice tblservice : listService) {
                rDetail = new Tblrequestdetail();
                rDetail.setRequestid(request);
                rDetail.setServiceid(tblservice.getId());
                rDetailDao.add(rDetail);
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblrequest findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblrequest.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tblrequest findByEmail(String Email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tblrequest> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Tblrequest updateRequest) {
        // TODO Auto-generated method stub
        return false;
    }

}
