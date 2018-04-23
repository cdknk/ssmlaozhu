package ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.Book;
import ssm.service.BookService;

@Controller
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books-crud")
	public String crudGrid() {
		return "books-crud";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books/")
	@ResponseBody // 把返回值通过某种格式(json或xml)转成文本作为响应
	public List<Book> findAll() {
		return bookService.findAll();
	}
}
