package com.mysite.mini_bobjo.dog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dog")
public class DogController {
	@Autowired
	private DogService dogService;
	
	@GetMapping
	public String dog() {
		return "dog/dog";
	}
	
	@GetMapping("/create")
	public String create() {
		return "dog/create";
	}
	
	@GetMapping("/list")
	public String list() {
		return "dog/list";
	}
	
	@GetMapping("/api")
	@ResponseBody
	public List<Dogs> getDogs() {
		return dogService.getDogs();
	}
	
	@PostMapping("/create")
	public void createDog(@RequestBody Dogs dog) {
		dogService.createDog(dog);
	}
}
