package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tblproject;
import entitybean.Tblprojecttype;

/**
 * Session Bean implementation class ProjectTypeDao
 */
@Stateless
public class ProjectTypeDao implements ProjectTypeDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public ProjectTypeDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblprojecttype projectType) {
        // TODO Auto-generated method stub
        if (projectType == null)
            return false;
        try {
            em.persist(projectType);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblprojecttype findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblprojecttype.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblprojecttype> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblprojecttype projecttype")
                    .getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tblprojecttype projectType) {
        // TODO Auto-generated method stub
        if (projectType == null)
            return false;
        try {
            em.remove(projectType);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblproject> getProjectsByTypeID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            return (List<Tblproject>) this.findByID(id)
                    .getTblprojectCollection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Tblprojecttype updateProjectType) {
        // TODO Auto-generated method stub
        if (updateProjectType == null)
            return false;
        if(updateProjectType.getId()<=0)
            return false;
        try {
            Tblprojecttype newType = em.find(Tblprojecttype.class, updateProjectType.getId());
            if(newType==null)
                return false;
            newType.setProjectName(updateProjectType.getProjectName());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
