package ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ssm.entity.Book;
import ssm.entity.User;
import ssm.service.BookService;

@Controller
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books-crud")
	public String crudGrid(@AuthenticationPrincipal(expression = "user") User curUser) {
		// @AuthenticationPrincipal默认拿到的是principal(UserDetailsImpl)，所以需要.user获得实体User对象（来自dao层）
		System.out.println("当前登录用户: " + curUser);
		return "books-crud";
	}
	
	// REST API

	@RequestMapping(method = RequestMethod.GET, value = "/books/")
	@ResponseBody // 把返回值通过某种格式(json或xml)转成文本作为响应
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/books/")
	@ResponseBody // 把新建的book返回去，但是多了id
	public Book create(@RequestBody Book book) { // 把请求内容解析成java对象，根据Content-Type请求头指定的格式
		System.out.println("create book:  " + book);
		bookService.create(book);
		System.out.println("created book: " + book);
		return book;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
	@ResponseBody
	public Book update(@PathVariable Integer id, @RequestBody Book book) {
		book.setId(id);
		bookService.update(book);
		return book;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 按照REST风格，响应没有内容时的状态码
	public void delete(@PathVariable Integer id) {
		bookService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/search")
	public String search(@ModelAttribute BookSearch bookSearch, Model model) {
		System.out.println("bookSearch: " + bookSearch);
		List<Book> books = bookService.search(bookSearch);
		model.addAttribute("books", books);
		return "books-search";
	}
}
