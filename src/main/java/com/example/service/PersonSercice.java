package com.example.service;

import java.util.List;

import com.example.model.Person;

public interface PersonSercice {

	List<Person> findAll();
	Person save(Person person);
	Person getById(Long id);
}
