package jSessions;
import jEntities.Roles;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RoleDAORemote {

	//Them 1 role moi
	public boolean addNewRole(Roles role);
	
	//Lay tat ca role
	public List<Roles> getAllRole();
	
	//Tim role bang id
	public Roles findRoleByID(int id);
}
