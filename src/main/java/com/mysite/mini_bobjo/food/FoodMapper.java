package com.mysite.mini_bobjo.food;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapper {
	
	Food getFoodById(Integer id);
	Food getFoodnameById(Integer id);
	List<Food> getFoodLimit10();
	void insertMessage(Food food);
}
