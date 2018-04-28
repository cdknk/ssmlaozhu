package ssm.dao;

import java.util.List;

import ssm.controller.BookSearch;
import ssm.entity.Book;

public interface BookDao {

	List<Book> findAll();

	void create(Book book);

	void update(Book book);

	void delete(Integer id);

	List<Book> search(BookSearch bookSearch);

}
