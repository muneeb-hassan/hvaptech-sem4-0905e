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
public class Eventresults implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int resultsid;

	private int userid;

	private int rank;

	private String description;

	@ManyToOne
	@JoinColumn(name="EventId")
	private Events eventid;

	private static final long serialVersionUID = 1L;

	public Eventresults() {
		super();
	}

	public int getResultsid() {
		return this.resultsid;
	}

	public void setResultsid(int resultsid) {
		this.resultsid = resultsid;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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

}
