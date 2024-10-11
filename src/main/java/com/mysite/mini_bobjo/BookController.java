package com.mysite.mini_bobjo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ModelAndView index(@RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "searchoption", required = false) String searchoption) {
        ModelAndView modelAndView = new ModelAndView("book");

        if (keyword != null && !keyword.trim().isEmpty()) {
            switch (searchoption) {
                case "타이틀":
                    modelAndView.addObject("books", bookService.searchTitle(keyword));
                    break;
                case "작가":
                    modelAndView.addObject("books", bookService.searchAuthor(keyword));
                    break;
                default:
                    // 기본 검색 옵션이나 잘못된 검색 옵션일 경우
                    modelAndView.addObject("books", bookService.getAllBooks());
                    return modelAndView;
            }
            modelAndView.addObject("keyword", keyword);
        } else {
            modelAndView.addObject("books", bookService.getAllBooks());
        }
        return modelAndView;
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer keyword, Model model) {
        // bookId에 해당하는 책을 가져옴
        Book book = bookService.getbookid(keyword);  // 단일 Book 객체 반환
        model.addAttribute("book", book);  
        return "detail";  
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam Integer year,
                          @RequestParam String detail) {
        // 새 책을 Book 객체로 생성
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setYear(year);
        newBook.setDetail(detail);
        
        // BookService를 통해 책을 추가
        bookService.addBook(newBook);
        
        // 책 목록 페이지로 리다이렉트
        return "redirect:/book";
    }
    @GetMapping("/add")
    public String add() {
    	return "addbook";
    }

}
