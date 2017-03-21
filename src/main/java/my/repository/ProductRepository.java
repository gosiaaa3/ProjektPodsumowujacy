package my.repository;

import my.model.Category;
import my.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findByCategory(String category);




}
