package entitybean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Tblhome implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String mainintrodution;

	private String domainintrodution;

	private String serviceintrodution;

	private static final long serialVersionUID = 1L;

	public Tblhome() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMainintrodution() {
		return this.mainintrodution;
	}

	public void setMainintrodution(String mainintrodution) {
		this.mainintrodution = mainintrodution;
	}

	public String getDomainintrodution() {
		return this.domainintrodution;
	}

	public void setDomainintrodution(String domainintrodution) {
		this.domainintrodution = domainintrodution;
	}

	public String getServiceintrodution() {
		return this.serviceintrodution;
	}

	public void setServiceintrodution(String serviceintrodution) {
		this.serviceintrodution = serviceintrodution;
	}

}
