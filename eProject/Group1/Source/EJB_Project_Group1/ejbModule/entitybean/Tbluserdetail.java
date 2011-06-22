package entitybean;

import static javax.persistence.FetchType.EAGER;

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
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(schema="dbo")
public class Tbluserdetail implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String password;

	private String fullname;

	private boolean sex;

	private String datebirth;

	private String address;

	private String phone;

	private boolean isactive;

	@ManyToOne
	@JoinColumn(name="LevelID")
	private Tbllevel levelid;

	@OneToMany(mappedBy="email", fetch = LAZY)
	private List<Tblrequest> tblrequestCollection;

	private static final long serialVersionUID = 1L;

	public Tbluserdetail() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isSex() {
		return this.sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getDatebirth() {
		return this.datebirth;
	}

	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isIsactive() {
		return this.isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Tbllevel getLevelid() {
		return this.levelid;
	}

	public void setLevelid(Tbllevel levelid) {
		this.levelid = levelid;
	}

	public List<Tblrequest> getTblrequestCollection() {
		return this.tblrequestCollection;
	}

	public void setTblrequestCollection(List<Tblrequest> tblrequestCollection) {
		this.tblrequestCollection = tblrequestCollection;
	}

}
