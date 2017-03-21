package my.service;

import my.model.Category;
import my.model.Image;
import my.model.Link;
import my.model.Product;
import my.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//public List<Product> fetchAllProducts(){
//        List<Product> products1 = new ArrayList<Product>();
//        Image smallImage = new Image("/home", "kotekBrzydki", "https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png");
//        Image bigImage = new Image("/home", "kotekBrzydki", "https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png");
//
//        products1.add(new Product(smallImage, bigImage, "tytul", "opis", 99.99));
//        products1.add(new Product(smallImage, bigImage, "tytul", "opis", 88.99));
//        products1.add(new Product(smallImage, bigImage, "tytul", "opis", 88.99));
//        return products1;
//    }


    public List<Product> fetchProducts(){
    List<Product> products= new ArrayList<Product>();
    Iterable <Product> iterable = productRepository.findAll();
        iterable.forEach(products::add);
        return products;
}

    public Product findProductById(Long id){
        return productRepository.findOne(id);
    }

   public List<Product> findProductsByCategory(String category){
       return productRepository.findByCategory(category);
   }

   public Set<Link> fetchAllCategories(){
       List<Product> products= fetchProducts();
       Set<String> categoriesAsString = new TreeSet<>();
       for(Product product:products){
           categoriesAsString.add(product.getCategory());
       }
       Set<Link> categories= new TreeSet<>();
//       treeset ma alfabetyucznie
       for(String category:categoriesAsString){
           Link link=new Link();
           link.setName(StringUtils.capitalize(category));
           link.setLink("/shop?category=" + category);
           categories.add(link);
       }
       return categories;
   }

   public void save(Product product){
       productRepository.save(product);
   }

   public void updateProduct(Product product){//usunelam long id
//   Product productToEdit = findProductById(id);
//       productToEdit.setId(id);
//       productToEdit.setTitle(product.getTitle());
//       productToEdit.setDescription(product.getDescription());
//       productToEdit.setPrice(product.getPrice());
//       productToEdit.setSmallImage(product.getSmallImage());
//       productToEdit.setBigImage(product.getBigImage());
//       productToEdit.setCategory(product.getCategory());
//       productRepository.save(productToEdit);
       productRepository.save(product);
   }
}
