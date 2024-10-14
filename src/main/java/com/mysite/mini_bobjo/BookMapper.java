package com.mysite.mini_bobjo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {

    Book getBookTitle(String BN);

    @Select("SELECT * FROM books")
    List<Book> getAllBooks();

    List<Book> searchTitle(String keyword);

    List<Book> searchAuthor(String keyword);

    Book getbookid(Integer keyword);

    void addBook(@Param("title") String title,
                 @Param("author") String author,
                 @Param("year") Integer year,
                 @Param("detail") String detail);

    void deletebook(@Param("ids") List<Integer> ids);  
    List<Book> getAllBooksPaged(@Param("offset") int offset, @Param("pageSize") int pageSize);

    // 전체 책 개수 조회
    int countBooks();
}
