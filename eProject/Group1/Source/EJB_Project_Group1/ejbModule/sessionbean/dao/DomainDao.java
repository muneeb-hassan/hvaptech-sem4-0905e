package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitybean.Tbldomain;
import entitybean.Tblservice;

/**
 * Session Bean implementation class DomainDao
 */
@Stateless
public class DomainDao implements DomainDaoRemote {
    
    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public DomainDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tbldomain domain) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Tbldomain findByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tbldomain> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tblservice> getServicesByDomainID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Tbldomain domain) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Tbldomain updateDomain) {
        // TODO Auto-generated method stub
        return false;
    }

}
