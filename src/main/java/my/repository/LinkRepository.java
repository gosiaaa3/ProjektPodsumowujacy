package my.repository;

import my.model.Link;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by RENT on 2017-03-15.
 */
public interface LinkRepository extends CrudRepository<Link, Long> {
}
