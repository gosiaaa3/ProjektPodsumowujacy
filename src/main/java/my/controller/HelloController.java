package my.controller;

import my.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by RENT on 2017-03-14.
 */
@RestController

public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("hello")//gniazdka pod ktore sie podłaczasz, cos co sie dzieje pod konkretnym url /hello lub hello, endpoint
    public Map<String, Object> hello(){
//        HashMap<String,String> map = new HashMap<String, String>();
//        map.put("Hello", "World");
//        return map;
        Map<String, Object> map = helloService.getData();
        map.put("users" ,helloService.getAllUsers());

        
        return map; //zwraca Jsona, obiekt dlatego @RestController to @Controller plus @ResponseBody
    }
}
