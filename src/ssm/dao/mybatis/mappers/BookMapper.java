package ssm.dao.mybatis.mappers;

import java.util.List;

import ssm.entity.Book;

public interface BookMapper {

	List<Book> findAll();

}
