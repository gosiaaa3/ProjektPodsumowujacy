package my.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import my.model.Link;
import my.model.Product;
import my.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.model.Category;
import my.repository.CategoryRepository;

@Service
public class CategoryService {

	
@Autowired
CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;


 public Set<Category> fetchCategories(){
	// List<Category> categories = new ArrayList<Category>();
	 Set<Category> categories = new HashSet<Category>();
	 Iterable<Category> iterables = categoryRepository.findAll();
	 iterables.forEach(categories::add);
	 return categories;
	 
 }

}
