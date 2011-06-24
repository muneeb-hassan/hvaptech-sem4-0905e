package jSessions;
import jEntities.Users;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserDAORemote {

	// Them 1 user moi
	public boolean addNewUser(Users user);

	// Lay tat ca user
	public List<Users> getAllUser();
	
	// Kiem tra user va pass
	public boolean checkUserAndPass(String username, String password);
	
	// Xoa user
	public boolean deleteUser(int id);
	
	//Cap nhat 1 user
	public boolean updateUser(Users user);
	
	// Tim user voi id
	public Users findUserByID(int id);
}
