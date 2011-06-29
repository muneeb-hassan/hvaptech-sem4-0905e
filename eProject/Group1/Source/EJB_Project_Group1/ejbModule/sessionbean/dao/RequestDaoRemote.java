package sessionbean.dao;

import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblrequest;
import entitybean.Tblservice;

@Remote
public interface RequestDaoRemote {
    public boolean add(Tblrequest request);

    public boolean add(Tblrequest request, List<Tblservice> listService);

    public Tblrequest findByID(int id);

    public List<Tblrequest> getAll();

    public List<Tblrequest> getListRequestsByEmail(String email);

    public boolean update(Tblrequest updateRequest);

    public boolean updateStatus(Tblrequest updateRequest, String status);

    public boolean updateStatusByID(int id, String status);

    public boolean remove(Tblrequest request);

}
