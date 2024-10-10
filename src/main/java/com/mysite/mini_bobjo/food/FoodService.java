package com.mysite.mini_bobjo.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
	@Autowired
	FoodMapper foodMapper;
	
	public Food getFood(Integer id) {
		return foodMapper.getFoodById(id);
	}
	public Food getFoods(Integer id) {
		return foodMapper.getFoodnameById(id);
	}
	 public void createMessage(Food food) {
	        foodMapper.insertMessage(food);
	    }
	public List<Food> getFoodLimit10(){
		return foodMapper.getFoodLimit10();
	}
}
