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
public class Tblprojecttype implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String projecttypename;
	private String ProjectName;

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

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

	public String getProjecttypename() {
		return this.projecttypename;
	}

	public void setProjecttypename(String projecttypename) {
		this.projecttypename = projecttypename;
	}

	public Set<Tblproject> getTblprojectCollection() {
		return this.tblprojectCollection;
	}

	public void setTblprojectCollection(Set<Tblproject> tblprojectCollection) {
		this.tblprojectCollection = tblprojectCollection;
	}

}
