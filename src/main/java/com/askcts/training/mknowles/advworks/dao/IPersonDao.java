/*
 * Summary:
 *
 * Interface used to assist in dependency injection.
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

import com.askcts.training.mknowles.advworks.model.Person;

public interface IPersonDao 
{	  
	  Person findPersonById(int id);
	  
	  List<Person> findAllPeople();

	  void persistPerson(Person person);
	  
	  void updatePerson(Person person);
	  
	  void deletePerson(Person person);	  
}
