package jEntities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Events implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventid;

	private String eventname;

	private String datecreate;

	private String datebegin;

	private String dateend;

	private String description;

	private String image;

	@ManyToOne
	@JoinColumn(name="TypeId")
	private Eventtypes typeid;

	@OneToMany(mappedBy="eventid")
	private List<Requests> requestsCollection;

	@OneToMany(mappedBy="eventid")
	private List<Eventresults> eventresultsCollection;

	private static final long serialVersionUID = 1L;

	public Events() {
		super();
	}

	public int getEventid() {
		return this.eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getEventname() {
		return this.eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getDatecreate() {
		return this.datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getDatebegin() {
		return this.datebegin;
	}

	public void setDatebegin(String datebegin) {
		this.datebegin = datebegin;
	}

	public String getDateend() {
		return this.dateend;
	}

	public void setDateend(String dateend) {
		this.dateend = dateend;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Eventtypes getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Eventtypes typeid) {
		this.typeid = typeid;
	}

	public List<Requests> getRequestsCollection() {
		return this.requestsCollection;
	}

	public void setRequestsCollection(List<Requests> requestsCollection) {
		this.requestsCollection = requestsCollection;
	}

	public List<Eventresults> getEventresultsCollection() {
		return this.eventresultsCollection;
	}

	public void setEventresultsCollection(List<Eventresults> eventresultsCollection) {
		this.eventresultsCollection = eventresultsCollection;
	}

}
