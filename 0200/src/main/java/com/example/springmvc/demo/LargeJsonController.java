package com.example.springmvc.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LargeJsonController {
	
	private static final Logger logger = LoggerFactory.getLogger(LargeJsonController.class);
	private static final String CHARSET_NAME_UTF8 = "utf-8"; 
	
	@RequestMapping("/gzip")
	public @ResponseBody String getGreeting() throws IOException {
		logger.warn(this.getClass().getClassLoader().getResource("").getPath());
		String json = readJsonFile();
		logger.warn(json.substring(0, 300));
		return json;
	}

	private String readJsonFile() throws IOException {
		String result = null;
		BufferedReader br = null;
		try {
			InputStream is = new FileInputStream(this.getClass().getClassLoader().getResource("").getPath() + "/test.json");
			br = new BufferedReader(new InputStreamReader(is , CHARSET_NAME_UTF8));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line=br.readLine()) != null) {
				line = line.trim();
				sb.append(line);
			}
			result = sb.toString();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return result;
	}

}