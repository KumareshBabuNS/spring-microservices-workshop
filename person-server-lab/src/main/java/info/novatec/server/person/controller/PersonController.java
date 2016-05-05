package info.novatec.server.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.novatec.server.person.boundary.PersonManagementService;
import info.novatec.server.person.entity.Person;

@RestController
@RequestMapping(value="/personen", method=RequestMethod.GET)
public class PersonController {
	
	@Autowired
	private PersonManagementService personManagementService;

	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<Person> retrievePersonen() {
		return personManagementService.findAll();
	}

}
