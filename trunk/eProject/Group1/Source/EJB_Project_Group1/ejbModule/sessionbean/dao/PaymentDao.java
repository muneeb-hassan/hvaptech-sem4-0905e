package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitybean.Tblpayment;

/**
 * Session Bean implementation class PaymentDao
 */
@Stateless
public class PaymentDao implements PaymentDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public PaymentDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblpayment payment) {
        // TODO Auto-generated method stub
        if (payment == null)
            return false;
        try {
            em.persist(payment);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblpayment findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblpayment.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblpayment> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblpayment payment").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblpayment> getListPaymentsByRequestID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            String sqlString = "select * from tblPayment where RequestID = ?";
            Query query = em.createNativeQuery(sqlString, Tblpayment.class);
            query.setParameter(1, id);
            List<Tblpayment> list = (List<Tblpayment>) query.getResultList();
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
            Tblpayment payment = em.find(Tblpayment.class, id);
            if (payment == null)
                return false;

            em.remove(payment);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Tblpayment payment) {
        // TODO Auto-generated method stub
        if (payment == null)
            return false;
        try {
            em.remove(payment);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblpayment updatePayment) {
        // TODO Auto-generated method stub
        if (updatePayment == null)
            return false;
        if (updatePayment.getId() <= 0)
            return false;
        try {
            Tblpayment newPayment = em.find(Tblpayment.class, updatePayment
                    .getId());
            if (newPayment == null)
                return false;
            newPayment.setPaidamount(updatePayment.getPaidamount());
            newPayment.setDate(updatePayment.getDate());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
