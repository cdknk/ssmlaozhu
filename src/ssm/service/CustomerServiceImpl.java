package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssm.dao.CustomerDao;
import ssm.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll(int page, int limit) {
		return customerDao.findAll(page, limit);
	}

	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	@Override
	public Customer findOne(Long id) {
		return customerDao.findOne(id);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Long id) {
		customerDao.delete(id);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		customerDao.batchDelete(idList);
	}

	@Override
	public Long count() {
		return customerDao.count();
	}

}
