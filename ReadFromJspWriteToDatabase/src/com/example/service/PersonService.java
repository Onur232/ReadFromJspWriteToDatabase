package com.example.service;
import java.util.List;

import com.example.beans.Person;
import com.example.dao.PersonDAO;

public class PersonService {
	
	private static PersonDAO personDAO;
	
	public PersonService() {
		personDAO=new PersonDAO();
//		initializeHibernate();
	}
	
	private void initializeHibernate() {
		personDAO.openCurrentSessionwithTransaction();
		personDAO.closeCurrentSessionwithTransaction();
		personDAO.openCurrentSession();
		personDAO.closeCurrentSession();
	}

	public void persist(Person entity) {
		personDAO.openCurrentSessionwithTransaction();
		personDAO.persist(entity);
		personDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(Person entity) {
		personDAO.openCurrentSessionwithTransaction();
		personDAO.update(entity);
		personDAO.closeCurrentSessionwithTransaction();
	}
	
	public Person findById(String id) {
		personDAO.openCurrentSession();
		Person person=personDAO.findById(id);
		personDAO.closeCurrentSession();
		return person;
	}
	
	public void delete(String id) {
		personDAO.openCurrentSessionwithTransaction();
		Person person=personDAO.findById(id);
		personDAO.delete(person);
		personDAO.closeCurrentSessionwithTransaction();
	}
	
	public List<Person> findAll(){
		personDAO.openCurrentSession();
		List<Person> persons=personDAO.findAll();
		personDAO.closeCurrentSession();
		return persons;
	}
	
	public void deleteAll() {
		personDAO.openCurrentSessionwithTransaction();
		personDAO.deleteAll();
		personDAO.closeCurrentSessionwithTransaction();
	}
	
	public PersonDAO employeeDao() {
		return personDAO;
	}
	
	public void dropTable() {
		personDAO.openCurrentSessionwithTransaction();
		personDAO.dropTable();
		personDAO.closeCurrentSessionwithTransaction();
	}
	
	public void createTable() {
		personDAO.openCurrentSessionwithTransaction();
		personDAO.createTable();
		personDAO.closeCurrentSessionwithTransaction();
	}
	

}
