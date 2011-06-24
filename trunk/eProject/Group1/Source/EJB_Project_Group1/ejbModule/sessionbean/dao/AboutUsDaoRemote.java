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

import entitybean.Tblaboutus;


@Remote
public interface AboutUsDaoRemote {
    public boolean add(Tblaboutus aboutus);

    public Tblaboutus findByID(int id);

    public List<Tblaboutus> getAll();

    public boolean remove(Tblaboutus aboutus);
    
    public boolean update(Tblaboutus updateAboutus);

}
