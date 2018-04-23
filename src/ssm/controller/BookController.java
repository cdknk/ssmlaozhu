package ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.Book;

@Controller
public class BookController {

	@RequestMapping(method = RequestMethod.GET, value = "/books/")
	@ResponseBody // 把返回值通过某种格式(json或xml)转成文本作为响应
	public List<Book> findAll() {
		List<Book> books = new ArrayList<>();
		Book book1 = new Book();
		book1.setId(1);
		book1.setAuthor("游贵贵");
		book1.setTitle("论喷子的自我修养");
		book1.setPublisher("Java7班");
		
		books.add(book1);
		
		return books;
	}
}
