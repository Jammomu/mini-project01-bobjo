package com.mysite.mini_bobjo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;
	
	public Test getTest(Integer id) {
		return testMapper.getTestById(id);
	}
	
//	public void createTest(Test test) {
//		testMapper.insertTest(test);
//	}
	
	public List<Test> getTestLimit5() {
		return testMapper.getTestLimit5();
	}
}
