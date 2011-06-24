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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Tblpagecontact implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String introdution;

	private static final long serialVersionUID = 1L;

	public Tblpagecontact() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntrodution() {
		return this.introdution;
	}

	public void setIntrodution(String introdution) {
		this.introdution = introdution;
	}

}
