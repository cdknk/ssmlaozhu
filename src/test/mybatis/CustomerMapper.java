package test.mybatis;

import java.util.List;

import ssm.entity.Customer;

public interface CustomerMapper {
	List<Customer> findAll(); 
}
