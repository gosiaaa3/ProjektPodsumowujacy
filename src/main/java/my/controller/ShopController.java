package my.controller;


import jdk.internal.dynalink.linker.LinkerServices;
import my.model.Category;
import my.model.Link;
import my.model.Product;
import my.service.CategoryService;
import my.service.ImageService;
import my.service.LinkService;
import my.service.ProductService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller // dostaniesz wynik w html restContr daje wynik w jsonie
public class ShopController {

    @Autowired
    private LinkService linkService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService CategoryService;

    @RequestMapping("shop")
    public ModelAndView shop(ModelAndView modelAndView, Principal principal) {
        modelAndView.setViewName("shop");
        modelAndView.addObject("link", new Link("Glowny", "#"));
        modelAndView.addObject("navigationLinks", linkService.fetchLinks());
        modelAndView.addObject("carouselImages", imageService.fetchImages());
        modelAndView.addObject("products", productService.fetchProducts());
        //List<String> categories = Arrays.asList("brzydkie", "brzydsze","najbrzydsze");
        modelAndView.addObject("categories", productService.fetchAllCategories());
        //  modelAndView.addObject("products", productService.fetchAllProducts());
        modelAndView.addObject("isLogin", principal != null);
        //modelAndView.addObject("isLogout", principal==null);
//        if(principal!=null){
//            modelAndView.addObject(principal.);
//        }

        return modelAndView;
    }

    @RequestMapping(value = "shop", params = {"category"}) //dzieki temu wie do ktorego shopu sie podniesc
    public ModelAndView shop(@RequestParam String category, ModelAndView modelAndView) {
        modelAndView.setViewName("shop");
        modelAndView.addObject("link", new Link("Glowny", "#"));
        modelAndView.addObject("navigationLinks", linkService.fetchLinks());
        modelAndView.addObject("carouselImages", imageService.fetchImages());
        //List<String> categories = Arrays.asList("brzydkie", "brzydsze","najbrzydsze");
        modelAndView.addObject("categories", productService.fetchAllCategories());
        modelAndView.addObject("products", productService.findProductsByCategory(category));
        modelAndView.addObject("active", StringUtils.capitalize(category));

        //  modelAndView.addObject("products", productService.fetchAllProducts());

        return modelAndView;
    }

    @RequestMapping("shop/categories")//wpisujemy url do momentu znaku zapytania
    public ModelAndView categoriedShop(@RequestParam String category, ModelAndView modelAndView) {
        modelAndView.setViewName("category");
        modelAndView.addObject("link", new Link("Glowny", "#"));
        modelAndView.addObject("navigationLinks", linkService.fetchLinks());
        modelAndView.addObject("carouselImages", imageService.fetchImages());
        modelAndView.addObject("categories", productService.fetchAllCategories());
        //Arrays.asList("d","s","a").stream().map(e-> new Link(e,"/shop?category="+e)).collect(Collectors.toSet);

        modelAndView.addObject("products", productService.findProductsByCategory(category));

        modelAndView.addObject("active", StringUtils.capitalize(category));
        return modelAndView;
    }


    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, Principal principal) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}



//KOMENTARZ do @PathVarieble i @RequestParam,
//@PathVarieble wyciaga z url zmienna i mo�na jej dalej uzywac w metodzie okre�laj�c jej nazwe np. long id, w url wyswietla sie jako np. product/1 a odnosisz sie do tego adresu w @RequestMapping("product/{id}")
//@RequestParam tez wyciaga dane z url, ale wyciagane sa parametry czegos np. category?categor1=brzydki&category2=brzydszy, w pasku wyswietla sie wiec i to ze to kategoria i jej nazwa
//zatem @RequestParam berzdiej s�uzy do filtrowania a @PathVarieble do nawigacji bo chodzi o czytelnosc dla uzytkownika tego co widzi w pasku url