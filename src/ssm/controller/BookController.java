package ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method = RequestMethod.POST, value = "/books/")
	@ResponseBody // 把新建的book返回去，但是多了id
	public Book create(@RequestBody Book book) { // 把请求内容解析成java对象，根据Content-Type请求头指定的格式
		System.out.println("create book:  " + book);
		bookService.create(book);
		System.out.println("created book: " + book);
		return book;
	}
}
