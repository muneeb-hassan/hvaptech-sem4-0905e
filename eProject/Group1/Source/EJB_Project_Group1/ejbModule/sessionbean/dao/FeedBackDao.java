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

import entitybean.Tblfeedback;

/**
 * Session Bean implementation class FeedBackDao
 */
@Stateless
public class FeedBackDao implements FeedBackDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public FeedBackDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblfeedback feedback) {
        // TODO Auto-generated method stub
        if (feedback == null)
            return false;
        try {
            em.persist(feedback);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblfeedback findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblfeedback.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblfeedback> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblfeedback feedback").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tblfeedback feedback) {
        // TODO Auto-generated method stub
        if (feedback == null)
            return false;
        try {
            em.remove(feedback);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblfeedback updateFeedback) {
        // TODO Auto-generated method stub
        if (updateFeedback == null)
            return false;
        if (updateFeedback.getId() <= 0)
            return false;
        try {
            Tblfeedback newFB = em.find(Tblfeedback.class, updateFeedback
                    .getId());
            if (newFB == null)
                return false;
            newFB.setFullname(updateFeedback.getFullname());
            newFB.setEmail(updateFeedback.getEmail());
            newFB.setComment(updateFeedback.getComment());
            newFB.setDatecreate(updateFeedback.getDatecreate());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
