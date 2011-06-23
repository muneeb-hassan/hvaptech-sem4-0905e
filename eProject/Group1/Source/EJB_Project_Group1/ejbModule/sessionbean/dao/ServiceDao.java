package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tbldomain;
import entitybean.Tblservice;

/**
 * Session Bean implementation class ServiceDao
 */
@Stateless
public class ServiceDao implements ServiceDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public ServiceDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblservice service) {
        // TODO Auto-generated method stub
        if (service == null)
            return false;
        try {
            em.persist(service);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblservice findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblservice.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblservice> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblservice service").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tbldomain getDomainByServiceID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            return this.findByID(id).getDomainid();
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
            Tblservice service = em.find(Tblservice.class, id);
            if (service == null)
                return false;

            em.remove(service);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Tblservice service) {
        // TODO Auto-generated method stub
        if (service == null)
            return false;
        try {
            em.remove(service);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblservice updateService) {
        // TODO Auto-generated method stub
        if (updateService == null)
            return false;
        if (updateService.getId() <= 0)
            return false;
        try {
            Tblservice newService = em.find(Tblservice.class, updateService
                    .getId());
            if (newService == null)
                return false;
            newService.setServicename(updateService.getServicename());
            newService.setDescription(updateService.getDescription());
            newService.setImage(updateService.getImage());
            newService.setPrice(updateService.getPrice());
            if (updateService.getDomainid() != null)
                newService.setDomainid(updateService.getDomainid());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
