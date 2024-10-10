package com.mysite.mini_bobjo.food;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	@GetMapping("/food")
	//@ResponseBody
	public String food() {
		return "food";
	}
	@GetMapping("/food/list")
	public String foodmain() {
		return "food/foodlist";
	}
	@GetMapping("/food/add")
	public String foodadd() {
		return "food/add";
	}
	@GetMapping("/food/detail")
	public String fooddetail() {
		return "food/detail";
	}
}
