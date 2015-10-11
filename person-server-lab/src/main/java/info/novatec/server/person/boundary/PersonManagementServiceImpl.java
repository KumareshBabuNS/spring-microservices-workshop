package info.novatec.server.person.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import info.novatec.server.person.entity.Person;
import info.novatec.server.person.repository.PersonRepository;

@Service("personManagementService")
public class PersonManagementServiceImpl implements PersonManagementService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public long count() {
		return personRepository.count();
	}

	@Override
	public void delete(Long id) {
		personRepository.delete(id);
	}

	@Override
	public void delete(Person person) {
		personRepository.delete(person);
	}

	@Override
	public void deleteAll() {
		personRepository.deleteAll();
	}

	@Override
	public boolean exists(Long id) {
		return personRepository.exists(id);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Page<Person> findAll(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	@Override
	public Person findOne(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	
}
