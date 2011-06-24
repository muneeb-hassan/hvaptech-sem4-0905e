package jSessions;

import jEntities.Users;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
public class UserDAO implements UserDAORemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addNewUser(Users user) {
		if (user == null)
			return false;
		try {
			em.persist(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("all")
	@Override
	public List<Users> getAllUser() {
		try {
			return em.createQuery("from Users").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("all")
	@Override
	public boolean checkUserAndPass(String username, String password) {
		String sql = "SELECT u FROM Users u WHERE u.password=:Username And u.password=:Password";
		Query query = em.createQuery(sql);
		query.setParameter("Username", username);
		query.setParameter("Password", password);
		List<Users> result = query.getResultList();
		if (result.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		if (id <= 0)
			return false;
		Users user = em.find(Users.class, id);
        if(user == null)
        	return false;
        
      	em.remove(user);
        return true;
	}

	@Override
	public boolean updateUser(Users user) {
		if (user == null)
            return false;
	
        em.merge(user);
        return true;
	}

	@Override
	public Users findUserByID(int id) {
		if (id <= 0) {
			return null;
		}
		try {
			return em.find(Users.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	
}
