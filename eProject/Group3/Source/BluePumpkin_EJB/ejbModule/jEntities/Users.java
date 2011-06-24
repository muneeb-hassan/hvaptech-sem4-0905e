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
public class Users implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;

	private String username;

	private String password;

	private boolean active;

	private String datecreate;

	private String firstname;

	private String lastname;

	private boolean gender;

	private String dateofbirth;

	private String address;

	private String email;

	private String phone;

	private String image;

	@ManyToOne
	@JoinColumn(name="RoleId")
	private Roles roleid;

	@OneToMany(mappedBy="userid")
	private List<Requests> requestsCollection;

	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDatecreate() {
		return this.datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Roles getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Roles roleid) {
		this.roleid = roleid;
	}

	public List<Requests> getRequestsCollection() {
		return this.requestsCollection;
	}

	public void setRequestsCollection(List<Requests> requestsCollection) {
		this.requestsCollection = requestsCollection;
	}

}
