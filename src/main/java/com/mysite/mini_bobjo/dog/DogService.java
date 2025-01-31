package com.mysite.mini_bobjo.dog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {
	@Autowired
	private DogMapper dogMapper;
	
	public Dogs getDog(Integer id) {
		return dogMapper.getDogById(id);
	}
	
	public void createDog(Dogs dog) {
		dogMapper.insertDog(dog);
	}
	
	public List<Dogs> getDogs() {
		return dogMapper.getDogs();
	}
}
