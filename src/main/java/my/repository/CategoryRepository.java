package my.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import my.model.Category;

public interface CategoryRepository  extends CrudRepository<Category, Long>{

}
