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
import com.askcts.training.mknowles.advworks.service.PersonService;
import com.askcts.training.mknowles.advworks.model.BusinessEntity;
import com.askcts.training.mknowles.advworks.service.BusinessEntityService;

@Controller
public class PersonController {

	@Autowired private PersonService personService;
	@Autowired private BusinessEntityService businessEntityService;
	
	@RequestMapping(value = "")
	public ModelAndView index() {
		List<Person> people = personService.findAllPeople();
		return new ModelAndView("index", "people", people);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("add", "person", new Person());
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Person newPerson) {
		BusinessEntity businessEntity = new BusinessEntity();
		businessEntityService.persistBusinessEntity(businessEntity);
		newPerson.setId(businessEntity.getId());
		personService.saveOrUpdatePerson(newPerson);
		return new ModelAndView("addEditConfirm", "person", newPerson);
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		Person person = personService.findPersonById(id);
		return new ModelAndView("edit", "person", person);
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute Person editedPerson, @PathVariable int id) {
		Person originalPerson = personService.findPersonById(id);
		originalPerson.setFirstName(editedPerson.getFirstName());
		originalPerson.setLastName(editedPerson.getLastName());
		personService.saveOrUpdatePerson(originalPerson);
		return new ModelAndView("addEditConfirm", "person", originalPerson);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		Person person = personService.findPersonById(id);
		return new ModelAndView("delete", "person", person);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public ModelAndView deleteConfirm(@ModelAttribute Person deletedPerson, @PathVariable int id) {
		String fullName = deletedPerson.getFirstName() + " " + deletedPerson.getLastName();
		personService.deletePerson(deletedPerson);
		businessEntityService.deleteBusinessEntity(new BusinessEntity(id));
		return new ModelAndView("deleteConfirm", "fullName", fullName);
	}
}
