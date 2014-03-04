/*
 * Summary:
 *
 * This class is responsible for handling web requests to the application from a browser.
 * URLs are mapped to methods that return views populated with data.
 *
 * Author: Michael Knowles
 * 
 * Date: March 3, 2014
 * 
 * Copyright: Copyright (c) 2014 Computer Technology Solutions, Inc.  ALL RIGHTS RESERVED
 *
 * MVC Training Project - Spring 2014
 */

package com.askcts.training.mknowles.advworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.askcts.training.mknowles.advworks.model.Person;
import com.askcts.training.mknowles.advworks.service.IPersonService;
import com.askcts.training.mknowles.advworks.model.BusinessEntity;
import com.askcts.training.mknowles.advworks.service.IBusinessEntityService;

@Controller
public class PersonController
{
	@Autowired private IPersonService personService;
	
	/**
	 * Summary:
	 * This method is called when users access the default of URL
	 * of the project (http://localhost:8080/).
	 * 
	 * Return:
	 * This method returns the "index" JSP page that lists 
	 * the people in the Adventure Works database.
	 */
	@RequestMapping(value = "")
	public ModelAndView index()
	{
		List<Person> people = personService.findAllPeople();
		return new ModelAndView("index", "people", people);
	}
	
	/**
	 * Summary:
	 * This method is called when users access http://localhost:8080/add.
	 * 
	 * Return:
	 * This method returns the "add" JSP page that displays a form a user
	 * can complete and submit in order to create a new person.
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add()
	{
		return new ModelAndView("add", "person", new Person());
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Person newPerson) 
	{			
		personService.persistPerson(newPerson);
		return new ModelAndView("addEditConfirm", "person", newPerson);
	}

	/**
	 * Summary:
	 * This method is called when users access http://localhost:8080/edit/{personID}.
	 * It calls the service layer to retrieve the data of the person that the user
	 * will edit.
	 * 
	 * Return:
	 * This method returns a populated "edit" JSP page that displays a form a user
	 * can complete and submit in order to edit a person's data.
	 * 
	 * Parameters:
	 * id = The ID of the person being edited
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) 
	{
		Person person = personService.findPersonById(id);
		return new ModelAndView("edit", "person", person);
	}

	/**
	 * Summary:
	 * This method is called when users submit the edit form from the edit page. It uses the
	 * service layer to write the submitted information to the database.
	 * 
	 * Return:
	 * This method returns a view that re-displays to the user the changes they made to the
	 * person's information in the database.
	 * 
	 * Parameters:
	 * Person = An object containing the data the user entered on the edit form
	 * id = The id of the edited person contained in the URL
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute Person editedPerson, @PathVariable int id) 
	{
		personService.updatePerson(editedPerson);
		return new ModelAndView("addEditConfirm", "person", editedPerson);
	}
	
	/**
	 * Summary:
	 * This method is called when users first select to delete a user from the database.
	 * 
	 * Return:
	 * This method returns a view that confirms the user's choice to delete the person from
	 * the database.
	 * 
	 * Parameters:
	 * id = The id of the person to be deleted; contained in the URL
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) 
	{
		Person person = personService.findPersonById(id);
		return new ModelAndView("delete", "person", person);
	}
	
	/**
	 * Summary:
	 * This method is called when users submits the form that confirms the decision to delete
	 * the person from the database.
	 * 
	 * Return:
	 * This method returns a view that displays the name of the user deleted from the database.
	 * 
	 * Parameters:
	 * Person = An object containing the data of the deleted person
	 * id = The id of the person to be deleted; contained in the URL
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public ModelAndView deleteConfirm(@ModelAttribute Person deletedPerson, @PathVariable int id) 
	{
		String fullName = deletedPerson.getFirstName() + " " + deletedPerson.getLastName();
		personService.deletePerson(deletedPerson);
		return new ModelAndView("deleteConfirm", "fullName", fullName);
	}
}
