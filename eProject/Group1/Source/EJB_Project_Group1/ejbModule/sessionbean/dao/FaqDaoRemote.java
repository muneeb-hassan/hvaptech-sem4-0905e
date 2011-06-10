package sessionbean.dao;

import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblfaq;

@Remote
public interface FaqDaoRemote {
    public boolean add(Tblfaq faq);

    public Tblfaq findByID(int id);

    public List<Tblfaq> getAll();

    public boolean remove(Tblfaq faq);

}
