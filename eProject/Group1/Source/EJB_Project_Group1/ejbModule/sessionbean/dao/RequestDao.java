package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    //    @SuppressWarnings("all")
    //    @Override
    //    public Tblrequest findByEmail(String email) {
    //        // TODO Auto-generated method stub
    //        if (email == null)
    //            return null;
    //        try {
    //            String sqlString = "select * from tblRequest where Email = ?";
    //            Query query = em.createNativeQuery(sqlString, Tblrequest.class);
    //            query.setParameter(1, email);
    //            List<Tblrequest> list = (List<Tblrequest>) query
    //                    .getResultList();
    //            if (list == null || list.size() <= 0)
    //                return null;
    //            return list.get(0);
    //        } catch (Exception e) {
    //            // TODO: handle exception
    //            e.printStackTrace();
    //            return null;
    //        }
    //    }

    @SuppressWarnings("all")
    @Override
    public List<Tblrequest> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblrequest request").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblrequest> getListRequestsByEmail(String email) {
        // TODO Auto-generated method stub
        if (email == null)
            return null;
        try {
            String sqlString = "select * from tblRequest where Email = ?";
            Query query = em.createNativeQuery(sqlString, Tblrequest.class);
            query.setParameter(1, email);
            List<Tblrequest> list = (List<Tblrequest>) query.getResultList();
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
    public boolean update(Tblrequest updateRequest) {
        // TODO Auto-generated method stub
        if (updateRequest == null)
            return false;
        if (updateRequest.getId() <= 0)
            return false;
        try {
            Tblrequest newRequest = em.find(Tblrequest.class, updateRequest
                    .getId());
            if (newRequest == null)
                return false;
            newRequest.setLocation(updateRequest.getLocation());
            newRequest.setNote(updateRequest.getNote());
            newRequest.setDaterequest(updateRequest.getDaterequest());
            newRequest.setDatebegin(updateRequest.getDatebegin());
            newRequest.setDatecomplete(updateRequest.getDatecomplete());
            newRequest.setTotalpaidamount(updateRequest.getTotalpaidamount());
            newRequest.setTotalpayment(updateRequest.getTotalpayment());
            newRequest.setStatus(updateRequest.getStatus());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStatus(Tblrequest updateRequest, String status) {
        // TODO Auto-generated method stub
        if (updateRequest == null)
            return false;
        if (updateRequest.getId() <= 0)
            return false;
        if (status == null || status == "")
            return false;
        try {
            Tblrequest newRequest = em.find(Tblrequest.class, updateRequest
                    .getId());
            if (newRequest == null)
                return false;
            newRequest.setStatus(status);
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStatusByID(int id, String status) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return false;
        if (status == null || status == "")
            return false;
        try {
            Tblrequest newRequest = em.find(Tblrequest.class, id);
            if (newRequest == null)
                return false;
            newRequest.setStatus(status);
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Tblrequest request) {
        // TODO Auto-generated method stub
        if (request == null)
            return false;
        try {
            em.remove(request);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
