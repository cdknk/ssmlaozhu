package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.CustomerDao;
import ssm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
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

}
