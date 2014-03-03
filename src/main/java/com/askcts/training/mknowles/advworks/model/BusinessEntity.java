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
public class BusinessEntity {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID", nullable=false)
	private int id;

	public BusinessEntity(){}
	public BusinessEntity(int id)
	{
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}
