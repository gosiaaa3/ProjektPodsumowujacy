package my.service;

import my.model.User;
import my.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-03-14.
 */
@Service
public class HelloService {
    //@Component
    //Repository
    //Controller
    //RestController

    //po Components cale klasy adnotujemy, @Beanem metody
    //skanowanie klas w poszukiwaniu adnotacji

   // @Controller trzeba dodac ResponseBidy jesli chcyemy zwrocic obiekt a nie wido a w REstController to zawarte


    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> getData(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Hello","World");
        return map;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        Iterable < User > iterable = userRepository.findAll();
        iterable.forEach(users::add);
        return users;
    }
}
