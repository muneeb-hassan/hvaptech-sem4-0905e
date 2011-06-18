package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tblaboutus;

/**
 * Session Bean implementation class AboutUsDao
 */
@Stateless
public class AboutUsDao implements AboutUsDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public AboutUsDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblaboutus aboutus) {
        // TODO Auto-generated method stub
        if (aboutus == null)
            return false;
        try {
            em.persist(aboutus);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblaboutus findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblaboutus.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblaboutus> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblaboutus aboutus").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tblaboutus aboutus) {
        // TODO Auto-generated method stub
        if (aboutus == null)
            return false;
        try {
            em.remove(aboutus);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblaboutus updateAboutus) {
        // TODO Auto-generated method stub
        if (updateAboutus == null)
            return false;
        if (updateAboutus.getId() <= 0)
            return false;
        try {
            Tblaboutus newAboutus = em.find(Tblaboutus.class, updateAboutus
                    .getId());//find persistent object
            if (newAboutus == null)
                return false;
            newAboutus.setIntroduction(updateAboutus.getIntroduction());//set update data to persistent object
            em.flush();//update about us by persistence the newAboutus object with database
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
