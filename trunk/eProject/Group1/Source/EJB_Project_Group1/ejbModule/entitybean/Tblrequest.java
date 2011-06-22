package entitybean;

import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Tblrequest implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String location;

	private String note;

	private BigDecimal totalpayment;

	private BigDecimal totalpaidamount;

	private String daterequest;

	private String datebegin;

	private String datecomplete;

	private String status;

	@ManyToOne
	@JoinColumn(name="Email", referencedColumnName="Email")
	private Tbluserdetail email;

	@OneToMany(mappedBy="requestid", fetch = EAGER)
	private List<Tblpayment> tblpaymentCollection;

	@OneToMany(mappedBy="requestid", fetch = EAGER)
	private List<Tblrequestdetail> tblrequestdetailCollection;

	private static final long serialVersionUID = 1L;

	public Tblrequest() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getTotalpayment() {
		return this.totalpayment;
	}

	public void setTotalpayment(BigDecimal totalpayment) {
		this.totalpayment = totalpayment;
	}

	public BigDecimal getTotalpaidamount() {
		return this.totalpaidamount;
	}

	public void setTotalpaidamount(BigDecimal totalpaidamount) {
		this.totalpaidamount = totalpaidamount;
	}

	public String getDaterequest() {
		return this.daterequest;
	}

	public void setDaterequest(String daterequest) {
		this.daterequest = daterequest;
	}

	public String getDatebegin() {
		return this.datebegin;
	}

	public void setDatebegin(String datebegin) {
		this.datebegin = datebegin;
	}

	public String getDatecomplete() {
		return this.datecomplete;
	}

	public void setDatecomplete(String datecomplete) {
		this.datecomplete = datecomplete;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tbluserdetail getEmail() {
		return this.email;
	}

	public void setEmail(Tbluserdetail email) {
		this.email = email;
	}

	public List<Tblpayment> getTblpaymentCollection() {
		return this.tblpaymentCollection;
	}

	public void setTblpaymentCollection(List<Tblpayment> tblpaymentCollection) {
		this.tblpaymentCollection = tblpaymentCollection;
	}

	public List<Tblrequestdetail> getTblrequestdetailCollection() {
		return this.tblrequestdetailCollection;
	}

	public void setTblrequestdetailCollection(List<Tblrequestdetail> tblrequestdetailCollection) {
		this.tblrequestdetailCollection = tblrequestdetailCollection;
	}

}
