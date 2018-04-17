package ssm.dao;

import java.util.List;

import ssm.entity.Customer;

public interface CustomerDao {

	List<Customer> findAll();

	void create(Customer customer);

	Customer findOne(Long id);

}
