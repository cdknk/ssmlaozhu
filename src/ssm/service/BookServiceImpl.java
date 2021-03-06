package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssm.controller.BookSearch;
import ssm.dao.BookDao;
import ssm.entity.Book;

@Service
@Transactional
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

	@Override
	public void delete(Integer id) {
		bookDao.delete(id);
	}

	@Override
	public List<Book> search(BookSearch bookSearch) {
		return bookDao.search(bookSearch);
	}

}
