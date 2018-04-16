package com.neu.online_shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.shopping_backend.dao.CategoryDAO;
import com.neu.shopping_backend.dto.Category;

@Controller
public class PageController {
	
	/*We have used DEPENDENCY INJECTION feature of spring framework
	 and "@Autowired" the class which implements DAO interfaces*/
	
	//Using @Autowired for dependency injection .No need to instantiate CategoryDAO again
	
	@Autowired
	private CategoryDAO categoryDAO;

	//Controller will always have a request mapping inside with defined values of multiple URLs
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting","Welcome to Spring web MVC");
		mv.addObject("title","Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting","Welcome to Spring web MVC");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting","Welcome to Spring web MVC");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	/*
	 * Methods to load all the products based on category
	 * */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting","Welcome to Spring web MVC");
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id ) {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting","Welcome to Spring web MVC");
		
		/*
		 * categoryDAO to fetch the single category for the title purposes
		 * */
		Category category = null;
		category=categoryDAO.get(id);
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		/*Passing the single category objects*/
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
//	//Using RequestParam
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
//		if(greeting == null)
//		{
//			greeting ="Hello there";
//		}
//		ModelAndView mv=new ModelAndView("page");
//		mv.addObject("greeting",greeting);
//		return mv;
//	}
	
	
	//Using PathVariable
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable(value="greeting", required=false)String greeting) {
		if(greeting == null)
		{
			greeting ="Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	
	
}
