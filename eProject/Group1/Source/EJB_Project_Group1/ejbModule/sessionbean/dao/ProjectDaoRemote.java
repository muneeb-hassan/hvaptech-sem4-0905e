package sessionbean.dao;

import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblproject;
import entitybean.Tblprojecttype;

@Remote
public interface ProjectDaoRemote {
    public boolean add(Tblproject project);

    public Tblproject findByID(int id);

    public List<Tblproject> getAll();

    public boolean remove(int id);
    
    public boolean update(Tblproject updateProject);

    public Tblprojecttype getProjectTypeByProjectID(int id);

}
