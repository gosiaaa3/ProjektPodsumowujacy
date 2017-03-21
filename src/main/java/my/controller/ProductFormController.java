package my.controller;

import my.model.Product;
import my.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RENT on 2017-03-18.
 */
@Controller
public class ProductFormController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product-form", method = RequestMethod.POST)
	public ModelAndView productForm(@ModelAttribute Product product, ModelAndView modelAndView) {
		productService.save(product);
		// modelAndView.addObject("product",productService.findProductById(product.getId()));

		modelAndView.setViewName("redirect:/shop");
		// kod 302 oznacza redirect i znowy przegladarka getem shopa pobiera
		// modelAndView.addObject("product", product);
		return modelAndView;
		// dodatkowe redirect
	}

	@RequestMapping(value = "/product-form", method = RequestMethod.GET)
	public ModelAndView productForm(ModelAndView modelAndView) {
		modelAndView.setViewName("productForm");
		modelAndView.addObject("product", new Product());
		modelAndView.addObject("categories", productService.fetchAllCategories());
		modelAndView.addObject("postUrl", "/product-form");
		return modelAndView;

	}

	@GetMapping("/product-edit/{id}")
	public ModelAndView productEdit(@PathVariable("id") Long id, ModelAndView modelAndView) {
		modelAndView = productForm(modelAndView);
		Product product = productService.findProductById(id);
		if (product != null) {
			modelAndView.addObject("product", product);
			modelAndView.addObject("postUrl", "/product-edit/" + id);//postem bedzie wysy³ane pod akcje product-edit +id

		} else {
			modelAndView.setViewName("redirect:/product-form");
		}
		return modelAndView;
	}

//	@PostMapping("/product-edit/{id}")
//	public String productUpdate(@PathVariable("id") Long id, @ModelAttribute Product product) {
//		productService.updateProduct(product);
//		return "redirect:/product/" + id;
//	}
	
	@PostMapping("/product-edit/{id}")
	public ModelAndView productUpdate(@PathVariable("id") Long id, @ModelAttribute Product product, ModelAndView modelAndView) {
		productService.updateProduct(product);
		modelAndView.setViewName("redirect:/product/" + id);
		return modelAndView;
	}

}
