package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonSercice;

@Service
public class PersonServiceImpl implements PersonSercice{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> findAll() {
		
		return personRepository.findAll();
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person getById(Long id) {
		
		return personRepository.findById(id).orElse(new Person());
	}

}
