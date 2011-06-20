package entitybean;

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
public class Tblproject implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	private String image;
	private String projectname;

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	@ManyToOne
	@JoinColumn(name="ProjectTypeID")
	private Tblprojecttype projecttypeid;

	private static final long serialVersionUID = 1L;

	public Tblproject() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Tblprojecttype getProjecttypeid() {
		return this.projecttypeid;
	}

	public void setProjecttypeid(Tblprojecttype projecttypeid) {
		this.projecttypeid = projecttypeid;
	}

}
