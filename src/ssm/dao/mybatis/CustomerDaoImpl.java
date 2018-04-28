package ssm.dao.mybatis;

import java.util.List;
import java.util.StringJoiner;

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
		return customerMapper.findAll((page - 1) * limit, limit);
	}

	@Override
	public void create(Customer customer) {
		customerMapper.create(customer);
	}

	@Override
	public Customer findOne(Long id) {
		return customerMapper.findOne(id);
	}

	@Override
	public void update(Customer customer) {
		customerMapper.update(customer);
	}

	@Override
	public void delete(Long id) {
		customerMapper.delete(id);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		customerMapper.batchDelete(idList);
	}

	@Override
	public Long count() {
		return customerMapper.count();
	}

}
