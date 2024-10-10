package com.mysite.mini_bobjo.dog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DogController {
	@GetMapping("/dog")
	@ResponseBody
	public String dog() {
		return "dog";
	}
}
