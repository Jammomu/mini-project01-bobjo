package com.mysite.mini_bobjo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addBook(Book book) {
        bookMapper.addBook(book.getTitle(), book.getAuthor(), book.getYear(), book.getDetail());
    }

}
