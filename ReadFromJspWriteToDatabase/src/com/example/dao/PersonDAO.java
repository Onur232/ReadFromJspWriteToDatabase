package com.example.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.beans.Person;


public class PersonDAO {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public Session openCurrentSession() {
		currentSession=getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction() {
		currentSession=getSessionFactory().openSession();
		currentTransaction=currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(Person.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession=currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	public void persist(Person entity) {
		getCurrentSession().save(entity);
	}

	public void update(Person entity) {
		getCurrentSession().update(entity);
	}
	
	public Person findById(String id) {
		Person person=(Person) getCurrentSession().get(Person.class, id);
		return person;
	}
	
	public void delete(Person entity) {
		getCurrentSession().delete(entity);
	}
	
	public List<Person> findAll(){
		List<Person> persons = getCurrentSession().createQuery("FROM Person").list();
		return persons;
	}
	
	public void deleteAll() {
		List<Person> entityList=findAll();
		for (Person person : entityList) {
			delete(person);
		}
	}

	//benim sonradan eklediðim metotlar. çalýþtýðý denenmeli. table'ý entity class ile hibernate'e
	//yaptýrmalýsýn. þu an database sql ile mysql tarafýndan yapýlýyor.
	@SuppressWarnings("deprecation")
	public void dropTable() {
		getCurrentSession().createSQLQuery("DROP TABLE people").executeUpdate();
		
	}
	
	@SuppressWarnings("deprecation")
	public void createTable() {
		getCurrentSession().createSQLQuery("CREATE TABLE people").executeUpdate();
	}

	//end of benim sonradan eklediðim metotlar
}
