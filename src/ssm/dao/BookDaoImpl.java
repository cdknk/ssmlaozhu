package ssm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	@Override
	public void create(Book book) {
		String sql = "insert into books (title, author, publisher) values(?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
					ps.setString(1, book.getTitle());
					ps.setString(2, book.getAuthor());
					ps.setString(3, book.getPublisher());
					return ps;
				}
			},
			keyHolder);
		book.setId(keyHolder.getKey().intValue());
	}

	@Override
	public void update(Book book) {
		String sql = "update books set title = ?, author = ?, publisher = ? where id = ?";
		jdbcTemplate.update(sql, 
				book.getTitle(), book.getAuthor(), book.getPublisher(), book.getId());
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
