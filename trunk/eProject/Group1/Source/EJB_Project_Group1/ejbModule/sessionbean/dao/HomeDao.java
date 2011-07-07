package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tblhome;

/**
 * Session Bean implementation class HomeDao
 */
@Stateless
public class HomeDao implements HomeDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public HomeDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblhome home) {
        // TODO Auto-generated method stub
        if (home == null)
            return false;
        try {
            em.persist(home);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblhome findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblhome.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblhome> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblhome home").getResultList();
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
            Tblhome home = em.find(Tblhome.class, id);
            if (home == null)
                return false;

            em.remove(home);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Tblhome home) {
        // TODO Auto-generated method stub
        if (home == null)
            return false;
        try {
            em.remove(home);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblhome updateHome) {
        // TODO Auto-generated method stub
        if (updateHome == null)
            return false;
        if (updateHome.getId() <= 0)
            return false;
        try {
            Tblhome newHome = em.find(Tblhome.class, updateHome.getId());//find persistent object
            if (newHome == null)
                return false;
            newHome.setMainintrodution(updateHome.getMainintrodution());//set update data to persistent object
            newHome.setDomainintrodution(updateHome.getDomainintrodution());
            newHome.setServiceintrodution(updateHome.getServiceintrodution());
            em.flush();//update about us by persistence the newAboutus object with database
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
