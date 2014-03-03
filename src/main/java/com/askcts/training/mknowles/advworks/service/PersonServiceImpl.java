package com.askcts.training.mknowles.advworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.askcts.training.mknowles.advworks.dao.PersonDao;
import com.askcts.training.mknowles.advworks.model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	/*@Override
	@Transactional
	public void persistPerson(Person person) {
		PersonDao.persistPerson(person);
	}

	@Override
	@Transactional
	public void updatePerson(Person person) {
		PersonDao.updatePerson(person);
	}*/
	
	
	@Override
	@Transactional
	public void saveOrUpdatePerson(Person person)
	{
		if(person.getPersonType() == null)
			person.setPersonType("EM");
		if(person.getNameStyle() == null)
			person.setNameStyle(false);
		personDao.saveOrUpdatePerson(person);
	}
	
	@Override
	@Transactional
	public Person findPersonById(int id) {
		return personDao.findPersonById(id);
	}

	@Override
	@Transactional
	public void deletePerson(Person person) {
		personDao.deletePerson(person);	
	}

	@Override
	@Transactional
	public List<Person> findAllPeople() {
		return personDao.findAllPeople();
	}
}
