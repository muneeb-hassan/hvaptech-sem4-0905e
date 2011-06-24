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

import entitybean.Tblpagecontact;


@Remote
public interface PageContactDaoRemote {
    public boolean add(Tblpagecontact pagecontact);

    public Tblpagecontact findByID(int id);

    public List<Tblpagecontact> getAll();

    public boolean remove(Tblpagecontact pagecontact);

    public boolean update(Tblpagecontact updatePagecontact);
    
}
