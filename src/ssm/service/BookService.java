package ssm.service;

import java.util.List;

import ssm.entity.Book;

public interface BookService {

	List<Book> findAll();

	void create(Book book);

	void update(Book book);

}
