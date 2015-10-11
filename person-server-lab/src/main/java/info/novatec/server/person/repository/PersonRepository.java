package info.novatec.server.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import info.novatec.server.person.entity.Person;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

}
