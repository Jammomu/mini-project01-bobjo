package com.mysite.mini_bobjo.dog;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DogMapper {
	Dogs getDogById(Integer id);
	
	void insertDog(Dogs dog);
	
	List<Dogs> getDogs(); 
}
