package ssm.service;

import java.util.List;

import ssm.dao.CustomerDao;
import ssm.entity.Customer;


public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
