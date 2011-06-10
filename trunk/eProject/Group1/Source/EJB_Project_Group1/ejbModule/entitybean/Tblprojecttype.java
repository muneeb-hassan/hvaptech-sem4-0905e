package entitybean;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Tblprojecttype implements Serializable {
	@Id
	private int id;

	private String projectname;

	@OneToMany(mappedBy="projecttypeid")
	private Set<Tblproject> tblprojectCollection;

	private static final long serialVersionUID = 1L;

	public Tblprojecttype() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectname() {
		return this.projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Set<Tblproject> getTblprojectCollection() {
		return this.tblprojectCollection;
	}

	public void setTblprojectCollection(Set<Tblproject> tblprojectCollection) {
		this.tblprojectCollection = tblprojectCollection;
	}

}
