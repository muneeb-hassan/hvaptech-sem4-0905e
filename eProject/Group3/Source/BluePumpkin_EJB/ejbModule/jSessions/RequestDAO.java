package jSessions;

import jEntities.Requests;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RequestDAO
 */
@Stateless
public class RequestDAO implements RequestDAORemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
    public RequestDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addNewReq(Requests req) {
		if (req == null)
			return false;
		try {
			em.persist(req);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteRequest(int id) {
		if (id <= 0)
			return false;
		Requests u = em.find(Requests.class, id);
		if (u == null)
			return false;
		em.remove(em.merge(u));
		return true;
	}

	@Override
	public Requests findRequestByID(int id) {
		if (id <= 0) {
			return null;
		}
		try {
			return em.find(Requests.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Requests> getAllRequest() {
		// TODO Auto-generated method stub
		try {
			return em.createQuery("from Requests").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateRequest(Requests req) {
		if (req == null)
			return false;
		em.merge(req);
		return true;
	}

}
