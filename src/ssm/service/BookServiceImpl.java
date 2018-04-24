package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.BookDao;
import ssm.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public void create(Book book) {
		bookDao.create(book);
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

}
