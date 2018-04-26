package ssm.dao.mybatis.mappers;

import java.util.List;

import ssm.entity.Customer;

public interface CustomerMapper {
	List<Customer> findAll();

	Long count();

	Customer findOne(Long id);

	void update(Customer customer);

	void delete(Long id);

	void batchDelete(List<Long> idList);

	void create(Customer customer); 
}
