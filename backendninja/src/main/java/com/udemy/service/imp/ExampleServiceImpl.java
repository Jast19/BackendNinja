package com.udemy.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> persona = new ArrayList<>();
		persona.add(new Person("jon", 23));
		persona.add(new Person("ata", 2));
		persona.add(new Person("toto", 93));
		persona.add(new Person("lalo", 43));
		LOG.info("ExampleServiceImpl x-x");
		return persona;
	}

}
