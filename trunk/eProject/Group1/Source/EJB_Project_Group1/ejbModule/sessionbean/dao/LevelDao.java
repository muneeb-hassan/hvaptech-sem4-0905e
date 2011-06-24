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

import entitybean.Tbllevel;
import entitybean.Tbluserdetail;

/**
 * Session Bean implementation class LevelDao
 */
@Stateless
public class LevelDao implements LevelDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public LevelDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tbllevel level) {
        // TODO Auto-generated method stub
        if (level == null)
            return false;
        try {
            em.persist(level);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tbllevel findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tbllevel.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tbllevel> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tbllevel level").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tbllevel level) {
        // TODO Auto-generated method stub
        if (level == null)
            return false;
        try {
            em.remove(level);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tbluserdetail> getUserDetailsByLevelID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            return (List<Tbluserdetail>) this.findByID(id)
                    .getTbluserdetailCollection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Tbllevel updateLevel) {
        // TODO Auto-generated method stub
        if (updateLevel == null)
            return false;
        if (updateLevel.getId() <= 0)
            return false;
        try {
            Tbllevel newLv = em.find(Tbllevel.class, updateLevel.getId());
            if (newLv == null)
                return false;
            newLv.setLevelname(updateLevel.getLevelname());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
