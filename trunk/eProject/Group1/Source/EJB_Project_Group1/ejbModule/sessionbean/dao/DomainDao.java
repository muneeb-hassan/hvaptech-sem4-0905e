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

import entitybean.Tbldomain;
import entitybean.Tblservice;

/**
 * Session Bean implementation class DomainDao
 */
@Stateless
public class DomainDao implements DomainDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public DomainDao() {
        // TODO Auto-generated constructor stub
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean add(Tbldomain domain) {
        // TODO Auto-generated method stub
        if (domain == null)
            return false;
        try {
            em.persist(domain);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tbldomain findByID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tbldomain.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("all")
    @Override
    public List<Tbldomain> getAll() {
        // TODO Auto-generated method stub
        try {
            return em.createQuery("from Tbldomain domain").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tblservice> getServicesByDomainID(int id) {
        // TODO Auto-generated method stub
        if (id <= 0)
            return null;
        try {
            return (List<Tblservice>) this.findByID(id)
                    .getTblserviceCollection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Tbldomain domain) {
        // TODO Auto-generated method stub
        if (domain == null)
            return false;
        try {
            em.remove(domain);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Tbldomain updateDomain) {
        // TODO Auto-generated method stub
        if (updateDomain == null)
            return false;
        if (updateDomain.getId() <= 0)
            return false;
        try {
            Tbldomain newDomain = em
                    .find(Tbldomain.class, updateDomain.getId());
            if (newDomain == null)
                return false;
            newDomain.setDomainname(updateDomain.getDomainname());
            em.flush();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
