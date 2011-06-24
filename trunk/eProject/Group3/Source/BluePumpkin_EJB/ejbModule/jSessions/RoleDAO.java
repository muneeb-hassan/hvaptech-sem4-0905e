package jSessions;

import jEntities.Roles;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RoleDAO
 */
@Stateless
public class RoleDAO implements RoleDAORemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
    EntityManager em;
	
    public RoleDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addNewRole(Roles role) {
		if (role == null)
            return false;
        try {
            em.persist(role);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public Roles findRoleByID(int id) {
		if (id <= 0) {
            return null;
        }
        try {
            return em.find(Roles.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
	}

	@SuppressWarnings("all")
	@Override
	public List<Roles> getAllRole() {
		try {
            return em.createQuery("from Roles").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
	}


}
