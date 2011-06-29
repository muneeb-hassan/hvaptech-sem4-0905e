package sessionbean.dao;
import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblpayment;


@Remote
public interface PaymentDaoRemote {
public boolean add(Tblpayment payment);
    
    public Tblpayment findByID(int id);

    public List<Tblpayment> getAll();
    
    public List<Tblpayment> getListPaymentsByRequestID(int id);

    public boolean remove(int id);
    
    public boolean remove(Tblpayment payment);
    
    public boolean update(Tblpayment updatePayment);

}
