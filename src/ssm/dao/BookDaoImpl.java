package ssm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ssm.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BookDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> findAll() {
		String sql = "select id, title, author, publisher from books";
		return jdbcTemplate.query(sql, new BookMapper());
	}

}

class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Book book = new Book();
		book.setId(resultSet.getInt(1));
		book.setTitle(resultSet.getString(2));
		book.setAuthor(resultSet.getString(3));
		book.setPublisher(resultSet.getString(4));
		return book;
	}
	
}
