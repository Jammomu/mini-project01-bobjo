package com.mysite.mini_bobjo.dog;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DogMapper {
	Dogs getDogById(Integer id);
	
	void insertDog(Dogs dog);
}
