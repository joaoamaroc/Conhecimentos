package spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Database of Product objects extending CrudRepository.
 * @author Prof. Júlio Machado
 * @author Renan Kummer
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	// Empty interface - uses only inherited methods.

}

