package entitybean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(schema="dbo")
public class Tbllevel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String levelname;

	@OneToMany(mappedBy="levelid", fetch = EAGER)
	private Set<Tbluserdetail> tbluserdetailCollection;

	private static final long serialVersionUID = 1L;

	public Tbllevel() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevelname() {
		return this.levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public Set<Tbluserdetail> getTbluserdetailCollection() {
		return this.tbluserdetailCollection;
	}

	public void setTbluserdetailCollection(Set<Tbluserdetail> tbluserdetailCollection) {
		this.tbluserdetailCollection = tbluserdetailCollection;
	}

}
