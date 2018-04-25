package ssm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ssm.entity.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DepartmentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Department> findAll() {
		String sql = "SELECT d.id, d.name, d.parent_id, d2.name parent_name "
				+ "FROM DEPARTMENTS d left join departments d2 on d.parent_id = d2.id";
		return jdbcTemplate.query(sql, new DepartmentRowMapper());
	}

	@Override
	public Department findOne(Long id) {
		String sql = "SELECT d.id, d.name, d.parent_id, d2.name parent_name "
				+ "FROM DEPARTMENTS d left join departments d2 on d.parent_id = d2.id "
				+ "where d.id = ?";		
		return jdbcTemplate.queryForObject(sql, new DepartmentRowMapper(), id);
	}

}

class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Department department = new Department();
		department.setId(resultSet.getLong(1));
		department.setName(resultSet.getString(2));
		department.setParentId(resultSet.getLong(3));
		department.setParentName(resultSet.getString(4));
		return department;
	}
	
}
