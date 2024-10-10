package com.mysite.mini_bobjo.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/food")
public class FoodController {
@Autowired
FoodService foodService;

	@GetMapping("/{id}")
	@ResponseBody
	public String getFood(@PathVariable("id") Integer id) {
		return foodService.getFood(id);
	}
	
	@GetMapping
	public String food() {
		return "food";
	}
	
	@GetMapping("/list")
	public String foodmain() {
		return "food/foodlist";
	}
	
	@GetMapping("/add")
	public String foodadd() {
		return "food/add";
	}
	
	@GetMapping("/detail")
	public String fooddetail() {
		return "food/detail";
	}

}
