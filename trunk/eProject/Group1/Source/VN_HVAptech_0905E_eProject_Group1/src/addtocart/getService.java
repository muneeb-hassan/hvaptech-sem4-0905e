package addtocart;

public class getService {
	
	private int idService;
	private String ServiceName;
	private int idDomain;
	
	public getService(){
	}
	
	public getService(int idService, String ServiceName, int idDomain){
		this.idService = idService;
		this.ServiceName = ServiceName;
		this.idDomain = idDomain;
	}
	
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public int getIdDomain() {
		return idDomain;
	}
	public void setIdDomain(int idDomain) {
		this.idDomain = idDomain;
	}
}
