package playground.spring.sia.chapterfour.tacocloud.persistence;

import org.springframework.data.repository.CrudRepository;
import playground.spring.sia.chapterfour.tacocloud.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
