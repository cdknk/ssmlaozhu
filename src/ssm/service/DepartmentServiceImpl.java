package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.DepartmentDao;
import ssm.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

}
