package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.model.Address;
import com.example.service.PersonSercice;

@RestController
public class PersonController {

	@Autowired
	private PersonSercice personService;
	
	@GetMapping("/person")
	public List<Person> getAllPeople(){
		return personService.findAll();
	}
	
	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable("id") Long id) {
		return personService.getById(id);
	}
	
	@PostMapping("/person")
	public Person saveNewPerson(@RequestBody Person person) {
		System.out.println(person);
		return personService.save(person);
	}
	
	@Bean
	public CommandLineRunner runner(PersonSercice personService) {
		return args -> {
			personService.save(new Person(1L, "John", "Doe", 
					new Address(1L, "123 Main st", "apt 34", "Dallas", "TX", "75678")));
			personService.save(new Person(2L, "Jane", "Who", 
					new Address(2L, "456 Second st", "", "Dallas", "TX", "75978")));
		};
	}
}
