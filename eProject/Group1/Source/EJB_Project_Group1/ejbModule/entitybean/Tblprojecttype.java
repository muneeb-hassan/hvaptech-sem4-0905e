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
package entitybean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(schema="dbo")
public class Tblprojecttype implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String ProjectName;

	@OneToMany(mappedBy="projecttypeid", fetch = EAGER)
	private List<Tblproject> tblprojectCollection;

	private static final long serialVersionUID = 1L;

	public Tblprojecttype() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	
	public List<Tblproject> getTblprojectCollection() {
		return this.tblprojectCollection;
	}

	public void setTblprojectCollection(List<Tblproject> tblprojectCollection) {
		this.tblprojectCollection = tblprojectCollection;
	}

}