package com.example.springmvc.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hi")
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody String getGreeting(@PathVariable String name) {
		String result = "Hello " + name;
		logger.debug("oops: " + result);
		logger.info("oops: " + result);
		logger.warn("oops: " + result);
		return result;
	}
	
}