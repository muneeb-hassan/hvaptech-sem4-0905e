/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package sessionbean.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitybean.Tbllevel;
import entitybean.Tbluserdetail;

/**
 * Session Bean implementation class UserDetailDao
 */
@Stateless
public class UserDetailDao implements UserDetailDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public UserDetailDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tbluserdetail userdetail) {
        // TODO Auto-generated method stub
        if (userdetail == null)
            return false;
        if (userdetail.getEmail() == null || userdetail.getPassword() == null)
            return false;
        if (this.isExist(userdetail.getEmail()))
            return false;
        try {
            userdetail.setPassword(helper.HashHelper.hashMD5(userdetail
                    .getPassword()));
            if (userdetail.getLevelid() == null) {
                LevelDao lvDao = new LevelDao();
                lvDao.setEm(em);
                userdetail.setLevelid(lvDao.findByID(2));
            }
            em.persist(userdetail);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tbluserdetail findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tbluserdetail.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public Tbluserdetail findByEmailAndPassword(String email, String password) {
        // TODO Auto-generated method stub
        if (email == null || password == null)
            return null;
        try {
            String sqlString = "select * from tblUserDetail where Email = ? AND Password = ?";
            Query query = em.createNativeQuery(sqlString, Tbluserdetail.class);
            query.setParameter(1, email);
            query.setParameter(2, helper.HashHelper.hashMD5(password));
            List<Tbluserdetail> list = (List<Tbluserdetail>) query
                    .getResultList();
            if (list == null || list.size() <= 0)
                return null;
            return list.get(0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

	@SuppressWarnings("all")
    @Override
    public Tbluserdetail findByEmail(String email) {
        // TODO Auto-generated method stub
        if (email == null)
            return null;
        try {
            String sqlString = "select * from tblUserDetail where Email = ?";
            Query query = em.createNativeQuery(sqlString, Tbluserdetail.class);
            query.setParameter(1, email);
            List<Tbluserdetail> list = (List<Tbluserdetail>) query
                    .getResultList();
            if (list == null || list.size() <= 0)
                return null;
            return list.get(0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tbluserdetail> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tbluserdetail userdetail")
                    .getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isExist(String email) {
        // TODO Auto-generated method stub
        return this.findByEmail(email) == null ? false : true;
    }

    @Override
    public Tbllevel getLevelByUserID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            return this.findByID(id).getLevelid();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tbluserdetail userdetail) {
        // TODO Auto-generated method stub
        if (userdetail == null)
            return false;
        try {
            em.remove(userdetail);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tbluserdetail updateUserdetail) {
        // TODO Auto-generated method stub
        if (updateUserdetail == null)
            return false;
        if (updateUserdetail.getId() <= 0)
            return false;
        try {
            Tbluserdetail newUserdetail = em.find(Tbluserdetail.class,
                    updateUserdetail.getId());
            if (newUserdetail == null)
                return false;
            newUserdetail.setAddress(updateUserdetail.getAddress());
            newUserdetail.setDatebirth(updateUserdetail.getDatebirth());
            newUserdetail.setFullname(updateUserdetail.getFullname());
            newUserdetail.setPhone(updateUserdetail.getPhone());
            newUserdetail.setSex(updateUserdetail.isSex());
            if (updateUserdetail.getLevelid() != null)
                newUserdetail.setLevelid(updateUserdetail.getLevelid());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
