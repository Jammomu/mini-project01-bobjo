package com.mysite.mini_bobjo.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/food")
public class FoodController {
@Autowired
FoodService foodService;

	// api로 json응답
//	@GetMapping("/{id}")
//	@ResponseBody
//	public Food getFood(@PathVariable("id") Integer id) {
//		return foodService.getFood(id);
//		//return foodService.getFood(id);
//	}
	@GetMapping
	public String food() {
		return "food";
	}
	
	// api로 json응답
	@GetMapping("/list")
	@ResponseBody
	public List<Food> getFoodLimit10(){
		return foodService.getFoodLimit10();
	}
	
	// detail 
	@GetMapping("/list/{id}")
	public String getFoods(@PathVariable("id") Integer id, Model model){
		Food food = foodService.getFoods(id);
		model.addAttribute("food", food);
		return "food/detail";
	}
	
    @GetMapping("/add")
    public String create() {
    	return "food/add";
    }
    @PostMapping("/add")
    @ResponseBody
    public void createMessage(@RequestBody Food food) {
        foodService.createMessage(food);
    }
	// list
//	@GetMapping("/list")
//	public String foodmain() {
//		return "food/foodlist";
//	}
//	
//	@GetMapping("/add")
//	public String foodadd() {
//		return "food/add";
//	}
	
	@GetMapping("/detail")
	public String fooddetail() {
		return "food/detail";
	}

}
