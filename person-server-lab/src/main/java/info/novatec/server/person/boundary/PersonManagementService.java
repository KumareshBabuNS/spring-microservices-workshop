package info.novatec.server.person.boundary;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import info.novatec.server.person.entity.Person;

public interface PersonManagementService {

	@Transactional
	Person save(Person person);

	@Transactional(readOnly=true)
	Person findOne(Long id);

	@Transactional(readOnly=true)
	Page<Person> findAll(Pageable pageable);

	@Transactional(readOnly=true)
	List<Person> findAll();

	@Transactional(readOnly=true)
	boolean exists(Long id);

	@Transactional
	void deleteAll();

	@Transactional
	void delete(Person person);

	@Transactional
	void delete(Long id);

	@Transactional(readOnly=true)
	long count();

}
