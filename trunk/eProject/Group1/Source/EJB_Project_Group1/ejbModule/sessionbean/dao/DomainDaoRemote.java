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

import javax.ejb.Remote;

import entitybean.Tbldomain;
import entitybean.Tblservice;

@Remote
public interface DomainDaoRemote {
    public boolean add(Tbldomain domain);

    public Tbldomain findByID(int id);

    public List<Tbldomain> getAll();

    public boolean remove(Tbldomain domain);
    
    public boolean update(Tbldomain updateDomain);

    public List<Tblservice> getServicesByDomainID(int id);

}