package ssm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import ssm.dao.BookDao;
import ssm.dao.mybatis.mappers.BookMapper;
import ssm.entity.Book;

@Repository("bookDaoMybatisImpl") // 解决bean id冲突
@Primary // 解决同一接口两个实现bean冲突
public class BookDaoImpl implements BookDao {

	private BookMapper bookMapper;
	
	@Autowired
	public BookDaoImpl(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
	public List<Book> findAll() {
		return bookMapper.findAll();
	}

	@Override
	public void create(Book book) {
		bookMapper.create(book);
		// id应该要set到book中
		System.out.println("after bookDaoMybatisImpl.ceate: " + book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
