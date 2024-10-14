package com.mysite.mini_bobjo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    public List<Book> searchTitle(String keyword) {
        return bookMapper.searchTitle(keyword);
    }

    public List<Book> searchAuthor(String keyword) {
        return bookMapper.searchAuthor(keyword);
    }

    public Book getbookid(Integer keyword) {
        return bookMapper.getbookid(keyword);
    }

    public void addBook(@RequestParam String title,
            @RequestParam String author,
            @RequestParam Integer year,
            @RequestParam String detail) {
    	bookMapper.addBook(title, author, year, detail);

    }
    public void deleteBook(List<Integer> ids) {
        bookMapper.deletebook(ids);  // 예: JPA를 사용하는 경우
    }
    public List<Book> getAllBooksPaged(int page, int pageSize) {
        int offset = (page - 1) * pageSize;  // 페이지 번호에 따른 오프셋 계산
        return bookMapper.getAllBooksPaged(offset, pageSize);
    }

    public int countBooks() {
        return bookMapper.countBooks();  // 전체 책 개수 반환
    }

}
