package com.askcts.training.mknowles.advworks.service;

import java.util.List;

import com.askcts.training.mknowles.advworks.model.Person;

public interface PersonService {
	//void persistPerson(Person person);
	Person findPersonById(int id);
	//void updatePerson(Person person);
	void saveOrUpdatePerson(Person person);
	void deletePerson(Person person);
	List<Person> findAllPeople();
}
