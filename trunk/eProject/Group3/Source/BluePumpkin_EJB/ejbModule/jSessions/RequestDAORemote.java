package jSessions;
import jEntities.Requests;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RequestDAORemote {

	//Them 1 request moi
	public boolean addNewReq(Requests req);
	
	//Lay tat ca request
	public List<Requests> getAllRequest();
	
	//Tim request bang id
	public Requests findRequestByID(int id);
	
	// Cap nhat 1 request
	public boolean updateRequest(Requests req);

	// Xoa request
	public boolean deleteRequest(int id);
}
