package ssm.dao.mybatis.mappers;

import java.util.List;

import ssm.entity.Customer;

public interface CustomerMapper {
	List<Customer> findAll(); 
}
