package entitybean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Tbldomain implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String domainname;

	@OneToMany(mappedBy="domainid")
	private Set<Tblservice> tblserviceCollection;

	private static final long serialVersionUID = 1L;

	public Tbldomain() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomainname() {
		return this.domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public Set<Tblservice> getTblserviceCollection() {
		return this.tblserviceCollection;
	}

	public void setTblserviceCollection(Set<Tblservice> tblserviceCollection) {
		this.tblserviceCollection = tblserviceCollection;
	}

}
