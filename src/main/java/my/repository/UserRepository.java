package my.repository;

import my.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by RENT on 2017-03-14.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
