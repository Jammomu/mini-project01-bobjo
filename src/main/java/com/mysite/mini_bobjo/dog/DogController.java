package com.mysite.mini_bobjo.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DogController {
	@Autowired
	private DogService dogService;
	
	@GetMapping("/dog")
	@ResponseBody
	public String dog() {
		return "dog";
	}
	
	@GetMapping("/dog/create")
	public String create() {
		return "dog/create";
	}
	
	@PostMapping("/dog/create")
	public void createDog(@RequestBody Dogs dog) {
		dogService.createDog(dog);
	}
}
