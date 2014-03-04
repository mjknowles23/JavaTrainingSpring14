/*
 * Summary:
 *
 * This class is used to model an entry in the BusinessEntity table in 
 * the AdventureWorks database.
 *
 * Author: Michael Knowles
 * 
 * Date: March 3, 2014
 * 
 * Copyright: Copyright (c) 2014 Computer Technology Solutions, Inc.  ALL RIGHTS RESERVED
 *
 * MVC Training Project - Spring 2014
 */

package com.askcts.training.mknowles.advworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

@Entity
@Table(name = "Person.BusinessEntity")
@SQLInsert(sql="Insert into Person.BusinessEntity default values")
public class BusinessEntity
{	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID", nullable=false)
	private int id;

	public BusinessEntity(){}
	public BusinessEntity(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
