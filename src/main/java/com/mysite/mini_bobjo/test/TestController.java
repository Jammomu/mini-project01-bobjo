package com.mysite.mini_bobjo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class TestController {
	@Autowired
	private TestService testService;
	
	
	@GetMapping("/tests")
	public String testmain() {
		return "tests";
	}
	
	@GetMapping("/tests/{id}")
	@ResponseBody
	public Test getTest(@PathVariable("id") Integer id) {
		return testService.getTest(id);
	}
	
	@GetMapping("/tests/api")
	@ResponseBody
	public List<Test> getTestLimit5() {
		return testService.getTestLimit5();
	}
	
	@GetMapping("/tests/create")
	public String create() {
		return "create";
	}
	
	@PostMapping("/create")
	public void createTest(@RequestBody Test test) {
		testService.createTest(test);
	}
}
