package com.neu.online_shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	//Controller will always have a request mapping inside with defined values of multiple URLs
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring web MVC");
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