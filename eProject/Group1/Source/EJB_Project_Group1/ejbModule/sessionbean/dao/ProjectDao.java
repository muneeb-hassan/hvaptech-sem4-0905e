package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tblproject;
import entitybean.Tblprojecttype;

/**
 * Session Bean implementation class ProjectDao
 */
@Stateless
public class ProjectDao implements ProjectDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public ProjectDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblproject project) {
        // TODO Auto-generated method stub
        if (project == null)
            return false;
        try {
            em.persist(project);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblproject findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblproject.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblproject> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblproject project").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tblprojecttype getProjectTypeByProjectID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            return this.findByID(id).getProjecttypeid();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tblproject project) {
        // TODO Auto-generated method stub
        if (project == null)
            return false;
        try {
            em.remove(project);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblproject updateProject) {
        // TODO Auto-generated method stub
        if (updateProject == null)
            return false;
        if (updateProject.getId() <= 0)
            return false;
        try {
            Tblproject newProject = em.find(Tblproject.class, updateProject
                    .getId());
            if (newProject == null)
                return false;
            newProject.setDescription(updateProject.getDescription());
            newProject.setImage(updateProject.getImage());
            newProject.setProjectname(updateProject.getProjectname());
            if (updateProject.getProjecttypeid() != null)
                newProject.setProjecttypeid(updateProject.getProjecttypeid());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
