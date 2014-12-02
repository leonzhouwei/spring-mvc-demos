package com.example.springmvc.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloController.class);

	@RequestMapping("/hi")
	public ModelAndView hi() {
		logger.info("oops");
		ModelAndView mav = new ModelAndView("admin/index");
		return mav;
	}

}