package my;

import my.model.Category;
import my.model.Image;
import my.model.Link;
import my.model.Product;
import my.model.User;
import my.repository.CategoryRepository;
import my.repository.ImageRepository;
import my.repository.LinkRepository;
import my.repository.ProductRepository;
import my.repository.UserRepository;
import my.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Created by RENT on 2017-03-14.
 */
@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
//tworzone beany, laczone zaleznosci, skanowany kontekst bez tego nie mozna czegos zautowiredowac, np service reposiyory
    @PostConstruct//mozna tez w innych klasach
    public void initDatabase(){
        User user1= new User();
        user1.setFirstname("Gosia");
        user1.setLastName("Kab");
        User user2= new User();
        user2.setFirstname("Madzia");
        user2.setLastName("Kaba");
        User user3= new User();
        user3.setFirstname("Lukasz");
        user3.setLastName("Kabac");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        linkRepository.save(new Link("About", "/home"));
        linkRepository.save(new Link("Service", "/home"));
        linkRepository.save(new Link("Contact", "/home"));
        linkRepository.save(new Link("Add Product", "/product-form"));



        imageRepository.save(new Image("/home","kotekBrzydki","http://www.differencebetween.info/sites/default/files/images/4/cat.jpg"));
        imageRepository.save(new Image("/home", "kotekJeszczeBrzydszy", "https://s-media-cache-ak0.pinimg.com/736x/e3/29/83/e32983fa1fe68aed8efbffc2651243c6.jpg"));
        imageRepository.save(new Image("/home", "kotekNajbrzydszy", "https://katzenworld.files.wordpress.com/2016/05/12.jpg?w=760"));
        imageRepository.save(new Image("/home", "kotekNajbrzydszy", "http://tostom.pl/files/320x150_jak-wybrac-odpowiednie-przysmaki-dla-kota-ccic.jpg"));

        
//        categoryRepository.save(new Category("Brzydkie"));
//        categoryRepository.save(new Category("Brzydsze"));
//        categoryRepository.save(new Category("Najbrzydsze"));

//        productRepository.save(new Product(new Image("http://www.differencebetween.info/sites/default/files/images/4/cat.jpg"),new Image("/home","kotekBrzydki","https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png"),"KotBrzydki","To jest calkiem brzydki kot", 10.10, new Category("Brzydkie")));
//        productRepository.save(new Product(new Image("/home","kotekBrzydki","http://4.bp.blogspot.com/_cw90jY6j5Bg/RqXalHiUG_I/AAAAAAAAABc/FuhZN0o0Quw/s320/Washing+the+cat+pic.jpg"),new Image("/home","kotekBrzydki","https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png"),"KotBrzydszy","To jest jeszcze brzydszy kot",99.99,new Category("Brzydsze")));
//        productRepository.save(new Product(new Image("/home","kotekBrzydki","http://4.bp.blogspot.com/_cw90jY6j5Bg/RqXalHiUG_I/AAAAAAAAABc/FuhZN0o0Quw/s320/Washing+the+cat+pic.jpg"),new Image("/home","kotekBrzydki","https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png"),"KotNajBrzydszy","To jest najrzydszy kot",88.88, new Category("Najbrzydsze")));
//      
        productRepository.save(new Product(new Image("/home","kotekBrzydki","http://www.differencebetween.info/sites/default/files/images/4/cat.jpg"),new Image("/home","kotekBrzydki","https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png"),"KotBrzydki","To jest calkiem brzydki kot",10.10, "brzydkie"));
        productRepository.save(new Product(new Image("/home","kotekBrzydki","https://s-media-cache-ak0.pinimg.com/736x/e3/29/83/e32983fa1fe68aed8efbffc2651243c6.jpg"),new Image("/home","kotekBrzydki","https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png"),"KotBrzydszy","To jest jeszcze brzydszy kot",99.99,"brzydsze"));
        productRepository.save(new Product(new Image("/home","kotekBrzydki","http://tostom.pl/files/320x150_jak-wybrac-odpowiednie-przysmaki-dla-kota-ccic.jpg"),new Image("/home","kotekBrzydki","https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png"),"KotNajBrzydszy","To jest najrzydszy kot",88.88, "najbrzydsze"));
        productRepository.save(new Product(new Image("/home","kotekBrzydki","http://tostom.pl/files/320x150_jak-wybrac-odpowiednie-przysmaki-dla-kota-ccic.jpg"),new Image("/home","kotekBrzydki","https://www.pethealthcare.co.za/sites/default/files/field/image/Blood%20groups%20for%20dogs%20and%20cats%20domestic%20shorthair%20cat.png"),"KotNajBrzydszy","To jest najrzydszy kot",88.88, "najbrzydsze"));
    }


}



//w klasach @Configuration tworzymy beany, podczas saknowania szuka klas @Configuration, metody oznaczone @Bean

//com.szymon
//   controller
//      HelloController

//Application ma controller scanscanuje wszystko pod katem komponentow COmponent Scan, Application musi byc zawsze w pakiecie bo leci blad typu pointer exception