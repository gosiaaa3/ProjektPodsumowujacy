package my.repository;

import my.model.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by RENT on 2017-03-15.
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
}
