package my.controller;

import my.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	


    @Autowired
    private HelloService helloService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        //to samo co setviewname
        //setView , mozemy ustalic jak ma to byc wyrenderowane np. pdf, excel czy inny widok
        modelAndView.addObject("hello", "Szymon");//doładowujemy dane , to co tu dodamy jest dalem rendedreowane przez model and view metoda
        modelAndView.addObject("users", helloService.getAllUsers());
        return modelAndView;
    }
    //to co wysyłamy do html plus to co ustawiamy w widoku , my widok zrobimy w themeleaf czyli w html, jest to spierane przez springa narzedzie do wyswietlanai, od jsp sie odchodzi, raczej htmlem
//znaczniki themeleafowe do iterowania
}
