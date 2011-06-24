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
public class Roles implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleid;

	private String rolename;

	private String description;

	@OneToMany(mappedBy="roleid")
	private List<Users> usersCollection;

	private static final long serialVersionUID = 1L;

	public Roles() {
		super();
	}

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Users> getUsersCollection() {
		return this.usersCollection;
	}

	public void setUsersCollection(List<Users> usersCollection) {
		this.usersCollection = usersCollection;
	}

}
