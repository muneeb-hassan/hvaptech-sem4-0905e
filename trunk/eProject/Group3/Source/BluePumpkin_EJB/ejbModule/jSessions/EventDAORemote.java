package jSessions;
import jEntities.Events;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EventDAORemote {

	//Them 1 event moi
	public boolean addNewEvent(Events event);
	
	//Lay tat ca event
	public List<Events> getAllEvent();
	
	//Tim event bang id
	public Events findEventByID(int id);
	
	// Cap nhat 1 event
	public boolean updateEvent(Events event);

	// Xoa event
	public boolean deleteEvent(int id);
}
