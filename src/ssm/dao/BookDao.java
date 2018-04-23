package ssm.dao;

import java.util.List;

import ssm.entity.Book;

public interface BookDao {

	List<Book> findAll();

}
