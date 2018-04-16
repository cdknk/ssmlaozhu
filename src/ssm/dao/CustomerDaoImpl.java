package ssm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ssm.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		Customer zs = new Customer();
		zs.setId(1L);
		zs.setName("zhangsan");
		zs.setAddress("hw");
		zs.setVip(true);
		customers.add(zs);
		return customers;
	}

}
