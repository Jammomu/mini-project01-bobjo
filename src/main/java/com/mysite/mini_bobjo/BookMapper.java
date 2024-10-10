package com.mysite.mini_bobjo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
	
	Book getBookTitle(String BN);
	

}
