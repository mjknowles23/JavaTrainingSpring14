package com.askcts.training.mknowles.advworks.dao;

import java.util.List;

import com.askcts.training.mknowles.advworks.model.Person;

public interface IPersonDao {
	
	  //void persistPerson(Person person);
	  
	  Person findPersonById(int id);
	  
	  //void updatePerson(Person person);
	  
	  void deletePerson(Person person);
	  
	  List<Person> findAllPeople();
	  
	  void saveOrUpdatePerson(Person person);
}
