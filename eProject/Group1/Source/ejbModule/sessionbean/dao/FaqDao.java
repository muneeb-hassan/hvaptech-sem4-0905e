package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tblfaq;

/**
 * Session Bean implementation class FaqDao
 */
@Stateless
public class FaqDao implements FaqDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public FaqDao() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean add(Tblfaq faq) {
        if (faq == null)
            return false;
        try {
            em.persist(faq);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Tblfaq findByID(int id) {
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblfaq.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @SuppressWarnings("all")
    @Override
    public List<Tblfaq> getAll() {
        try {
            return em.createQuery("from Tblfaq faq").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tblfaq faq) {
        if (faq == null)
            return false;
        try {
            em.remove(faq);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
