package com.example.product.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@RequestMapping("/get-time")
	public ModelAndView getCurrentTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("DisplayTime.jsp");// adding view name
		mav.addObject("dateTime",dateTime);// adding mode(raw data)
		
		
		
		return mav;// returning the model and view data together	
		
	}
	@RequestMapping(path = "/add-product",method = RequestMethod.POST )
	public ModelAndView addProduct(Product product) {
		productService.addProduct(product);
		return new ModelAndView("redirect:/index.jsp");		
	}
	@RequestMapping("/displayProduct")
	public ModelAndView findAll() {
		List<Product> products=productService.findAll();
		return new ModelAndView("displayProduct.jsp", "products", products);
	}
	@RequestMapping("/delete-product")
	public ModelAndView deleteProduct( @RequestParam("product_id")int id)
	{
		productService.deleteProduct(id);
		return new ModelAndView("redirect:/displayProduct");
	}
	@RequestMapping(path = "/update-product",method = RequestMethod.GET)
    public ModelAndView editProduct(@RequestParam("product_id") int id) {
        Product product = productService.findById(id);
        return new ModelAndView("updateProduct.jsp", "product", product);
    }

    @RequestMapping(path = "/update-product",method = RequestMethod.POST )
//    //public ModelAndView updateProduct(@RequestParam("product_id") int id,
//                                      @RequestParam("title") String title,
//                                      @RequestParam("description") String description,
//                                      @RequestParam("quantity") int quantity,
//                                      @RequestParam("price") double price) {
        public ModelAndView updateProduct(@ModelAttribute Product product) 
    {
        productService.updateProduct(product);
        return new ModelAndView("redirect:/displayProduct");
    }
}
