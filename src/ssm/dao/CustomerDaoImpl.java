package ssm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ssm.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Customer> findAll() {
		String sql = "SELECT id, name, address, vip FROM CUSTOMERS";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}

}

class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Customer customer = new Customer();
		customer.setId(resultSet.getLong(1));
		customer.setName(resultSet.getString(2));
		customer.setAddress(resultSet.getString(3));
		customer.setVip(resultSet.getBoolean(4));
		return customer;
	}
	
}