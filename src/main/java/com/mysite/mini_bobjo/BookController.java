package com.mysite.mini_bobjo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "searchoption", required = false) String searchoption) {
        ModelAndView modelAndView = new ModelAndView("index");  // index.jsp 대신 index.html로 렌더링

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
    public String detail() {
        return "detail";  // detail.jsp 대신 detail.html로 렌더링
    }
}
