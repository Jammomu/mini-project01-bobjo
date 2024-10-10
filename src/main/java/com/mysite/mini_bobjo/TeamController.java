package com.mysite.mini_bobjo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class TeamController {
	@GetMapping
	public String main() {
		return "main";
	}
	
	@GetMapping("/test")
	public String test() {
		return "tests";
	}
	
	@GetMapping("/dog")
	public String dog() {
		return "dogs";
	}
	
	@GetMapping("/book")
	public String book() {
		return "books";
	}
	
	@GetMapping("/food")
	public String food() {
		return "foods";
	}
}
