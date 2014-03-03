package com.askcts.training.mknowles.advworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person.Person")
public class Person {
	

		@Id
		@Column(name="BusinessEntityID", nullable=false)
		private int id;
		
		@Column(name="PersonType", nullable=false)
		private String personType;
		
		@Column(name="NameStyle", nullable=false)
		private Boolean nameStyle;
		
		@Column(name="FirstName", nullable=false)
		private String firstName;
		
		@Column(name="LastName", nullable=false)
		private String lastName;
		
		@Column(name="EmailPromotion", nullable=false)
		private int emailPromotion;
		
		public Person(){}
		
		public Person(int id, String firstName, String lastName)
		{
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public int getId(){
			return id;
		}
		
		public void setId(int id){
			this.id = id;
		}
		
		public String getPersonType(){
			return personType;
		}
		
		public void setPersonType(String personType){
			this.personType = personType;
		}
		
		public Boolean getNameStyle(){
			return nameStyle;
		}
		
		public void setNameStyle(Boolean nameStyle){
			this.nameStyle = nameStyle;
		}
		
		public String getFirstName(){
			return firstName;
		}
		
		public void setFirstName(String firstName){
			this.firstName = firstName;
		}
		
		public String getLastName(){
			return lastName;
		}
		
		public void setLastName(String lastName){
			this.lastName = lastName;
		}

		public int getEmailPromotion(){
			return emailPromotion;
		}
		
		public void setEmailPromotion(int emailPromotion){
			this.emailPromotion = emailPromotion;
		}
}