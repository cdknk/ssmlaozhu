package ssm.dao;

import java.util.List;

import ssm.entity.Department;

public interface DepartmentDao {

	List<Department> findAll();

	Department findOne(Long id);

}
