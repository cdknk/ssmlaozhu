package ssm.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import ssm.entity.Customer;

public interface CustomerService {

	// RW或者RO都可以读
	@PreAuthorize("hasAnyAuthority('PERM_CUSTOMER_RW', 'PERM_CUSTOMER_RO')")
	List<Customer> findAll(int page, int limit);

	// 仅RW可写
	@PreAuthorize("hasAuthority('PERM_CUSTOMER_RW')")
	void create(Customer customer);

	Customer findOne(Long id);

	void update(Customer customer);

	void delete(Long id);

	void batchDelete(List<Long> idList);

	Long count();
}
