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

import entitybean.Tblfaq;

/**
 * Session Bean implementation class FaqDao
 */
@Stateless
public class FaqDao implements FaqDaoRemote {

    @PersistenceContext
    EntityManager em;

    /**
     * Default constructor. 
     */
    public FaqDao() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean add(Tblfaq faq) {
        if (faq == null)
            return false;
        try {
            em.persist(faq);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tblfaq findByID(int id) {
        if (id <= 0) {
            return null;
        }
        try {
            return em.find(Tblfaq.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @SuppressWarnings("all")
    @Override
    public List<Tblfaq> getAll() {
        try {
            return em.createQuery("from Tblfaq faq").getResultList();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public boolean remove(int id) {
        if (id <= 0)
            return false;
        
        Tblfaq faq = em.find(Tblfaq.class, id);
        if(faq == null)
        	return false;
        
      	em.remove(faq);
        return true;
    }

	@Override
	public boolean update(Tblfaq faq) {
		if (faq == null)
            return false;
	
        em.merge(faq);
        return true;
	}
    
}
