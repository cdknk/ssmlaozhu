package ssm.service;

import java.util.List;

import ssm.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	void create(Customer customer);

}
