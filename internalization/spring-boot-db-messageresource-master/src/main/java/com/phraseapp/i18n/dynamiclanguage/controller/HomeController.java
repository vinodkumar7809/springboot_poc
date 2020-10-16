package com.phraseapp.i18n.dynamiclanguage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
//	@GetMapping("/homePage")
//	public String viewHomePage(Model model, HttpServletRequest request) {
//		
//		model.addAttribute("pageTitle", "Home-Shopme Admin");
//		Locale currentLocale = request.getLocale();
//		String countryCode = currentLocale.getCountry();
//		String displayCountry = currentLocale.getDisplayCountry();
//		String language = currentLocale.getLanguage();
//		String displayLanguage = currentLocale.getDisplayLanguage();
//		
//		System.out.println(countryCode +":"+ displayCountry);
//		
//		System.out.println(language +":"+ displayLanguage);
//		
//		return "index";
//	}
	
	

}
