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
public class Tblrequestdetail implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int serviceid;

	private BigDecimal payment;

	@ManyToOne
	@JoinColumn(name="RequestID")
	private Tblrequest requestid;

	private static final long serialVersionUID = 1L;

	public Tblrequestdetail() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public BigDecimal getPayment() {
		return this.payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public Tblrequest getRequestid() {
		return this.requestid;
	}

	public void setRequestid(Tblrequest requestid) {
		this.requestid = requestid;
	}

}
