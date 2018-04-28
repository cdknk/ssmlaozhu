package ssm.dao.mybatis.mappers;

import java.util.List;

import ssm.controller.BookSearch;
import ssm.entity.Book;

public interface BookMapper {

	List<Book> findAll();

	void create(Book book);

	List<Book> search(BookSearch bookSearch);

}
