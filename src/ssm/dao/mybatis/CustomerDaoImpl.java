package ssm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import ssm.dao.CustomerDao;
import ssm.dao.mybatis.mappers.CustomerMapper;
import ssm.entity.Customer;

@Repository
@Primary
public class CustomerDaoImpl implements CustomerDao {

	private CustomerMapper customerMapper;
	
	@Autowired // 注入mapper
	public CustomerDaoImpl(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	@Override
	public List<Customer> findAll(int page, int limit) {
		return customerMapper.findAll();
	}

	@Override
	public void create(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchDelete(List<Long> idList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return 1L;
	}

}
