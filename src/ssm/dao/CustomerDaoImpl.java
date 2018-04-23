package ssm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;

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
	public List<Customer> findAll(int page, int limit) {
		String sql = "SELECT id, name, address, vip, picture_path FROM CUSTOMERS order by id desc "
				     + "offset ? limit ?";
		return jdbcTemplate.query(sql, new CustomerRowMapper(), (page - 1) * limit, limit);
	}

	@Override
	public void create(Customer customer) {
		String sql = "insert into customers(name, address, vip) values(?, ?, ?)";
		jdbcTemplate.update(sql, 
				customer.getName(), customer.getAddress(), customer.getVip());
	}

	@Override
	public Customer findOne(Long id) {
		String sql = "SELECT id, name, address, vip, picture_path FROM CUSTOMERS where id = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
	}

	@Override
	public void update(Customer customer) {
		String sql = "update customers "
				+ "set name = ?, address = ?, vip = ?, picture_path = ? "
				+ "where id = ?";
		jdbcTemplate.update(sql, 
				customer.getName(), customer.getAddress(), customer.getVip(), customer.getPicturePath(),
				customer.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from customers where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		// in (31, 32)
		if (idList.isEmpty()) {
			throw new RuntimeException("请选择要删除的行");
		}
		StringJoiner joiner = new StringJoiner(
				",", 
				"delete from customers where id in (",
				")");
		for (Long id : idList) {
			joiner.add("?");
		}
		String sql = joiner.toString();
		System.out.println("batchDelete: " + sql);
		jdbcTemplate.update(sql, idList.toArray()); // sql传参通过数组传的
	}

	@Override
	public Long count() {
		String sql = "select count(*) from customers";
		return jdbcTemplate.queryForObject(sql, Long.class);
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
		customer.setPicturePath(resultSet.getString(5));
		return customer;
	}
	
}