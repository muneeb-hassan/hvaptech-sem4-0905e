package jSessions;

import jEntities.Events;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EventDAO
 */
@Stateless
public class EventDAO implements EventDAORemote {

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
    public EventDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addNewEvent(Events event) {
		if (event == null)
			return false;
		try {
			em.persist(event);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEvent(int id) {
		if (id <= 0)
			return false;
		Events u = em.find(Events.class, id);
		if (u == null)
			return false;
		em.remove(em.merge(u));
		return true;
	}

	@Override
	public Events findEventByID(int id) {
		if (id <= 0) {
			return null;
		}
		try {
			return em.find(Events.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Events> getAllEvent() {
		try {
			return em.createQuery("from Events").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public boolean updateEvent(Events event) {
		if (event == null)
			return false;
		em.merge(event);
		return true;
	}

}
