package com.mysite.mini_bobjo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}
