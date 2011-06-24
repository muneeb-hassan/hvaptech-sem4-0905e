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

import entitybean.Tblpagecontact;

/**
 * Session Bean implementation class PageContactDao
 */
@Stateless
public class PageContactDao implements PageContactDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public PageContactDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tblpagecontact pagecontact) {
        // TODO Auto-generated method stub
        if (pagecontact == null)
            return false;
        try {
            em.persist(pagecontact);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblpagecontact findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblpagecontact.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tblpagecontact> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tblpagecontact pagecontact")
                    .getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tblpagecontact pagecontact) {
        // TODO Auto-generated method stub
        if (pagecontact == null)
            return false;
        try {
            em.remove(pagecontact);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tblpagecontact updatePagecontact) {
        // TODO Auto-generated method stub
        if (updatePagecontact == null)
            return false;
        if (updatePagecontact.getId() <= 0)
            return false;
        try {
            Tblpagecontact newPage = em.find(Tblpagecontact.class,
                    updatePagecontact.getId());
            if (newPage == null)
                return false;
            newPage.setIntrodution(updatePagecontact.getIntrodution());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
