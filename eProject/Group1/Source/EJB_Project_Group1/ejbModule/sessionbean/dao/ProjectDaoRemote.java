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
