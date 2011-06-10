package sessionbean.dao;

import java.util.List;

import javax.ejb.Remote;

import entitybean.Tblproject;
import entitybean.Tblprojecttype;

@Remote
public interface ProjectTypeDaoRemote {
    public boolean add(Tblprojecttype projectType);

    public Tblprojecttype findByID(int id);

    public List<Tblprojecttype> getAll();

    public boolean remove(Tblprojecttype projectType);

    public List<Tblproject> getProjectsByTypeID(int id);

}
