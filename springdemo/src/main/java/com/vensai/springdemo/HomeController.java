package com.vensai.springdemo;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	DevRepository devRepo;
	
//	@RequestMapping("home")
//	public String home(HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		String name = req.getParameter("name");
//		System.out.println("hi" + name);
//		session.setAttribute("name", name);
////		System.out.println("Hi");
//		return "home";
//	}
	
	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name") String myName) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("home");
		return mv;
	}

	/*@RequestMapping("home")
	public ModelAndView home(Developer dev) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", dev);
		mv.setViewName("home");
		return mv;
  }*/
	
   @RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/addPerson")
	public String addPerson(Employee emp) {
		devRepo.save(emp);
		return "home";
	}
	
	@RequestMapping("/getPerson")
	public ModelAndView getPerson(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("display");
		Employee employee = devRepo.findById(id).orElse(new Employee());
		mv.addObject(employee);
		return mv;
	}
	
	@RequestMapping("/getAllPerson")
	public ModelAndView getAllPerson() {
		Iterable<Employee> list = devRepo.findAll();
	    ModelAndView map = new ModelAndView("display");
	    map.addObject("lists", list);
	    return map;
	}
}
