package my.controller;

import my.model.Link;
import my.model.Product;
import my.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{id}") //pathVariable wyciaga id do zmiennej
    public ModelAndView shop(@PathVariable("id") Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("product");
        Product productById = productService.findProductById(id);  
        modelAndView.addObject("product", productById);
        if (productById == null) {
            modelAndView = null;
        }

        return modelAndView;
    }


}



