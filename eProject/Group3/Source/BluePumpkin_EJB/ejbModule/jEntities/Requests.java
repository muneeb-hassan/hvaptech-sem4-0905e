package jEntities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Requests implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int requestid;

	private String daterequest;

	private String state;

	private String description;

	@ManyToOne
	@JoinColumn(name="EventId")
	private Events eventid;

	@ManyToOne
	@JoinColumn(name="UserId")
	private Users userid;

	private static final long serialVersionUID = 1L;

	public Requests() {
		super();
	}

	public int getRequestid() {
		return this.requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getDaterequest() {
		return this.daterequest;
	}

	public void setDaterequest(String daterequest) {
		this.daterequest = daterequest;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Events getEventid() {
		return this.eventid;
	}

	public void setEventid(Events eventid) {
		this.eventid = eventid;
	}

	public Users getUserid() {
		return this.userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

}
