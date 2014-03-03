package com.askcts.training.mknowles.advworks.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.askcts.training.mknowles.advworks.model.Person;

@Repository("personDao")
public class PersonDao implements IPersonDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*@Override
	public void persistPerson(Person person) {
		sessionFactory.getCurrentSession().persist(person);
	}

	@Override
	public void updatePerson(Person person) {
		sessionFactory.getCurrentSession().update(person);
	}*/
	
	@Override
	public Person findPersonById(int id) {
		return (Person) sessionFactory.getCurrentSession().get(Person.class, id);
	}
	
	@Override
	public void deletePerson(Person person) {
		sessionFactory.getCurrentSession().delete(person);
	}
	
	@Override
	public List<Person> findAllPeople()
	{
		return (List<Person>)sessionFactory.getCurrentSession().createCriteria(Person.class).list();
	}
	
	@Override
	public void saveOrUpdatePerson(Person person)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(person);
	}
}
