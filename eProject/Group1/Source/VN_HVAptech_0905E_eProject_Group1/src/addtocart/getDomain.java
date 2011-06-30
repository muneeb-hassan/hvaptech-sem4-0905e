package addtocart;

public class getDomain {

	private int idDomain;
	private String DomainName;

	public getDomain(){
		
	}
	
	public getDomain(int idDomain, String DomainName) {
		this.idDomain = idDomain;
		this.DomainName = DomainName;
	}
	
	public int getIdDomain() {
		return idDomain;
	}
	public void setIdDomain(int idDomain) {
		this.idDomain = idDomain;
	}
	public String getDomainName() {
		return DomainName;
	}
	public void setDomainName(String domainName) {
		DomainName = domainName;
	}
}
