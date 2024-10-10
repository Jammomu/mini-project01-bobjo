package com.mysite.mini_bobjo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
	
	Book getBookTitle(String BN);
    @Select("SELECT * FROM books")
    List<Book> getAllBooks();
    public List<Book> searchTitle(String keyword);

    public List<Book> searchAuthor(String keyword);
    
    

}
