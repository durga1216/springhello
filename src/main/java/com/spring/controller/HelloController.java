package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/welcome")

public class HelloController {
	
    @RequestMapping(method = RequestMethod.GET)

	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hai, welcome durga **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

}
