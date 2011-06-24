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

import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Tbllevel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String levelname;

	@OneToMany(mappedBy="levelid", fetch = EAGER)
	private List<Tbluserdetail> tbluserdetailCollection;

	private static final long serialVersionUID = 1L;

	public Tbllevel() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevelname() {
		return this.levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public List<Tbluserdetail> getTbluserdetailCollection() {
		return this.tbluserdetailCollection;
	}

	public void setTbluserdetailCollection(List<Tbluserdetail> tbluserdetailCollection) {
		this.tbluserdetailCollection = tbluserdetailCollection;
	}

}
