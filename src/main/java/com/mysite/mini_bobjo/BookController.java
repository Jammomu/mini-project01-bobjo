package com.mysite.mini_bobjo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/book")
    public String book(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "searchoption", required = false, defaultValue = "타이틀") String searchoption,
            @RequestParam(value = "page", defaultValue = "1") int page,  // 페이지 번호 파라미터 추가
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,  // 페이지 크기 파라미터 추가
            Model model) {

        if (keyword != null && !keyword.trim().isEmpty()) {
            switch (searchoption) {
                case "작가":
                    model.addAttribute("books", bookService.searchAuthor(keyword));
                    break;
                case "타이틀":
                default:
                    model.addAttribute("books", bookService.searchTitle(keyword));
                    break;
            }
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("books", bookService.getAllBooksPaged(page, pageSize));  // 페이징된 데이터 가져오기
        }

        int totalBooks = bookService.countBooks();  // 전체 책 개수 가져오기
        int totalPages = (int) Math.ceil((double) totalBooks / pageSize);  // 전체 페이지 수 계산
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "book";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("book", bookService.getbookid(id));
        return "detail";
    }

    @GetMapping("/addbook")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("year") Integer year,
                          @RequestParam("detail") String detail) {
        bookService.addBook(title, author, year, detail);
        return "redirect:/book";
    }

    @GetMapping("/add")
    public String add() {
        return "insertbook";
    }

    @PostMapping("/delete")
    public String deleteBooks(@RequestParam("ids") List<Integer> ids) {
        bookService.deleteBook(ids);  // 여러 책 삭제하는 서비스 호출
        return "redirect:/book";  // 삭제 후 책 목록으로 리다이렉트
    }
}
