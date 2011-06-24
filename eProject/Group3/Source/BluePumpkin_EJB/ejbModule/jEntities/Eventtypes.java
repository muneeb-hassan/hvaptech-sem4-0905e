package jEntities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Eventtypes implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int typeid;

	private String typename;

	private String description;

	@OneToMany(mappedBy="typeid")
	private List<Events> eventsCollection;

	private static final long serialVersionUID = 1L;

	public Eventtypes() {
		super();
	}

	public int getTypeid() {
		return this.typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Events> getEventsCollection() {
		return this.eventsCollection;
	}

	public void setEventsCollection(List<Events> eventsCollection) {
		this.eventsCollection = eventsCollection;
	}

}
