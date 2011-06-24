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
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="dbo")
public class Tblservice implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String servicename;

	private String description;

	private String image;

	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name="DomainID")
	private Tbldomain domainid;

	private static final long serialVersionUID = 1L;

	public Tblservice() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServicename() {
		return this.servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Tbldomain getDomainid() {
		return this.domainid;
	}

	public void setDomainid(Tbldomain domainid) {
		this.domainid = domainid;
	}

}
