/*
 * Summary:
 *
 * This class is responsible for handling read and write requests for People
 * to the AdventureWorks database using Hibernate.
 *
 * Author: Michael Knowles
 * 
 * Date: March 3, 2014
 * 
 * Copyright: Copyright (c) 2014 Computer Technology Solutions, Inc.  ALL RIGHTS RESERVED
 *
 * MVC Training Project - Spring 2014
 */

package com.askcts.training.mknowles.advworks.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.askcts.training.mknowles.advworks.model.Person;

@Repository("personDao")
public class PersonDao implements IPersonDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Person findPersonById(int id)
	{
		return (Person) sessionFactory.getCurrentSession().get(Person.class, id);
	}
	
	@Override
	public List<Person> findAllPeople()
	{
		return (List<Person>)sessionFactory.getCurrentSession().createCriteria(Person.class).list();
	}
	
	@Override
	public void persistPerson(Person person)
	{
		sessionFactory.getCurrentSession().persist(person);
	}
	
	@Override
	public void updatePerson(Person person)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(person);
	}
	
	@Override
	public void deletePerson(Person person) 
	{
		sessionFactory.getCurrentSession().delete(person);
	}
}
