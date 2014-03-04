/*
 * Summary:
 *
 * Likely overkill for this project, but this class is used to remove business logic
 * from the controller class and specify transactions.
 *
 * Author: Michael Knowles
 * 
 * Date: March 3, 2014
 * 
 * Copyright: Copyright (c) 2014 Computer Technology Solutions, Inc.  ALL RIGHTS RESERVED
 *
 * MVC Training Project - Spring 2014
 */

package com.askcts.training.mknowles.advworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.askcts.training.mknowles.advworks.dao.IPersonDao;
import com.askcts.training.mknowles.advworks.model.BusinessEntity;
import com.askcts.training.mknowles.advworks.model.Person;

@Service("personService")
public class PersonService implements IPersonService
{
	@Autowired
	IPersonDao personDao;
	@Autowired private IBusinessEntityService businessEntityService;

	@Override
	@Transactional
	public void persistPerson(Person person)
	{
		// Set values for non-null fields of new person entry
		person.setPersonType("EM");
		person.setNameStyle(false);
	
		// Create new Business Entity to satisfy foreign key dependency
		// of an entry in the Person table.
		BusinessEntity businessEntity = new BusinessEntity();
		businessEntityService.persistBusinessEntity(businessEntity);
		person.setId(businessEntity.getId());
		
		personDao.persistPerson(person);
	}
	
	@Override
	@Transactional
	public void updatePerson(Person person)
	{
		// Get all the existing information of the chosen person so that NULLS will
		// not be entered when updating the person entry.
		Person originalPerson = findPersonById(person.getId());
	
		originalPerson.setFirstName(person.getFirstName());
		originalPerson.setLastName(person.getLastName());

		personDao.updatePerson(originalPerson);
	}
	
	@Override
	@Transactional
	public Person findPersonById(int id)
	{
		return personDao.findPersonById(id);
	}

	@Override
	@Transactional
	public void deletePerson(Person person) 
	{
		int id = person.getId();
		personDao.deletePerson(person);	
		businessEntityService.deleteBusinessEntity(new BusinessEntity(id));
	}

	@Override
	@Transactional
	public List<Person> findAllPeople() 
	{
		return personDao.findAllPeople();
	}
}
