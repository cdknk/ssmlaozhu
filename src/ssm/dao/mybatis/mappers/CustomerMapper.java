package ssm.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.entity.Customer;

public interface CustomerMapper {
	// 把简单类型的参数打包成map，模拟bean
	List<Customer> findAll(@Param("offset") long offset, @Param("limit") long limit);

	Long count();

	// 单个简单类型参数无需@Param
	Customer findOne(Long id);

	void update(Customer customer);

	void delete(Long id);

	// 如(1, 3, 5)
	void batchDelete(@Param("idList") List<Long> idList);

	void create(Customer customer); 
}
