package com.mysite.mini_bobjo.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	public Test getTestById(Integer id);
	void insertTest(Test test);
	List<Test> getTestLimit5();
}
